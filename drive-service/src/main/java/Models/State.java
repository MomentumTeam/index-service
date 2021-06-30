package Models;

import Enums.ConvertUserDest;
import Enums.ElasticOperation;
import Enums.ErrorOperation;
import Exceptions.MultipleExceptions;
import Config.Config;
import Rabbit.Producer;
import RabbitModels.ErrorMessage;
import Services.DataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class State {
    private static final Logger LOGGER = LogManager.getLogger(State.class);
    public MultipleExceptions multipleExceptions;
    public boolean error;
    public String fileId;
    public ElasticOperation elasticOperation;
    public FileMetadata metadata;
    public Document document;
    public String[] descendants;
    public boolean sendToParsingService;
    public ArrayList<Document> descendantDocuments;
    public boolean fileExists;
    public static Producer producer;

    static {
        try {
            producer = new Producer();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public State(String fileId, ElasticOperation elasticOperation){
        this.fileId = fileId;
        this.elasticOperation = elasticOperation;
        this.document = new Document(fileId, elasticOperation);
        this.metadata = null;
        this.error = false;
        this.fileExists = true;
        this.multipleExceptions = new MultipleExceptions();
        this.descendants = null;
        this.sendToParsingService = false;
        this.descendantDocuments = new ArrayList<Document>();

    }

    public static String cleanFileName(String fileName){
        String cleanFileName = fileName.replaceAll("[$&+,:;=?@#|'<>.^*()%!{}-]"," ");
        cleanFileName = cleanFileName.replaceAll("[^A-Za-z0-9\\x{0590}-\\x{05FF}\\x{0600}-\\x{06FF}\n]"," ");
        cleanFileName = cleanFileName.replaceAll("[\\t\\n\\r]+"," ");
        cleanFileName = cleanFileName.replaceAll("(\\t|\\r?\\n)+", " ");
        cleanFileName = cleanFileName.trim().replaceAll("\\s+", " "); // Without spaces
        cleanFileName = cleanFileName.toLowerCase();
        return cleanFileName;
    }

    public void receiveMetadata(){
        try{
            this.metadata = FileMetadata.getMetadata(this.fileId);
            // if(this.metadata.getFileName() != null){
            //     this.metadata.setFileName(cleanFileName(this.metadata.getFileName()));
            // }
        }
        catch(Exception e){
            if(e.getMessage().indexOf("NOT_FOUND") != -1){
                this.fileExists = false;
            }
            LOGGER.error(String.format("Error in receiving metadata of '%s': %s",this.fileId, e.getMessage()));
        }
    }

    public void errorOccurred(){
        this.error = true;
    }

    public boolean getError(){
        return this.error;
    }

    public void setMetadata(){
        this.document.setMetadata(this.metadata);
    }

    public void addException(String fileId, String errorMessage){
        this.multipleExceptions.add(fileId, errorMessage);
    }

    public void processMetadata(){
        if(this.metadata == null){
            this.errorOccurred();
            this.addException(this.fileId, String.format("Error in receiving metadata of %s",
                    fileId));
        }
        else{
            this.setMetadata();
        }
    }

    public void receiveDescendants(){
        try {
            if(this.descendants == null){
                this.descendants = DataService.getDescendants(this.fileId);
            }
        }
        catch(Exception e) {
            this.descendants = null;
            this.errorOccurred();
            this.addException(this.fileId, e.getMessage());
        }
    }

    public boolean isFolder() {
        try {
            if (this.metadata != null && metadata.getType().equals(Config.FOLDER_TYPE)) {
                return true;
            } else if(metadata == null){
                this.receiveDescendants();
                if (this.descendants == null){
                    this.descendants = new String[0];
                    return true;
                } else if(this.descendants.length != 0) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        catch (Exception e) {
            this.descendants = new String[0];
            return true;
        }
    }

    public void setDataTime(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataTime = dateFormat.format(date);
        this.document.setDataTime(dataTime);
    }


    public void receiveAllPermissions() {
        Permission[] permissions;
        String userDest = ConvertUserDest.get(this.metadata.getAppId());

        try {
            permissions = Permission.getAllPermissions(this.fileId, userDest);
        }
        catch(Exception e) {
            permissions = null;
            if(this.elasticOperation == ElasticOperation.CREATE){
                this.errorOccurred();
                this.addException(this.fileId, e.getMessage());
            }
        }
        this.document.setPermissions(permissions);
    }

    public boolean folderPermissionChange(){
        return this.elasticOperation == ElasticOperation.PERMISSIONS_UPDATE && this.isFolder();
    }

    public Permission[] getSpecificPermissions(String id, String destUser){
        Permission[] permissions;
        try{
            permissions = Permission.getSpecificPermissions(id, destUser);
        }
        catch(Exception e){
            permissions = null;
            this.errorOccurred();
            this.addException(id, e.getMessage());
        }
        return permissions;
    }

    public Permission[] getAllPermissions(String id, String destUser){
        Permission[] permissions;
        try{
            permissions = Permission.getAllPermissions(id, destUser);
        }
        catch(Exception e){
            permissions = null;
            this.errorOccurred();
            this.addException(id, e.getMessage());
        }
        return permissions;
    }

    public void addDescendantDocument(Document descendantDocument){
        this.descendantDocuments.add(descendantDocument);
    }

    public void processPermissionChangeOnFolder(Permission[] permissions){
        if (permissions != null) {
            this.receiveDescendants();
            if (this.descendants != null && this.descendants.length > 0) {
                for (String descendantId : this.descendants) {
                    Document descendantDocument = new Document(descendantId, ElasticOperation.PERMISSIONS_UPDATE);
                    descendantDocument.setPermissions(permissions);
                    this.addDescendantDocument(descendantDocument);
                }
            }
        }
    }

    public void setPermissions (Permission[] permissions){
        this.document.setPermissions(permissions);
    }

    public void processPermissions(){
        Permission[] permissions;

        String userDest = ConvertUserDest.get(this.metadata.getAppId());

        if(this.elasticOperation == ElasticOperation.PERMISSIONS_UPDATE) {
            permissions = this.getSpecificPermissions(this.fileId, userDest);
            if (this.folderPermissionChange()){ // Permissions changed on folder
                this.processPermissionChangeOnFolder(permissions);
            }
        }
        else{ //CREATE
            permissions = this.getAllPermissions(fileId, userDest);
        }
        setPermissions(permissions);
        LOGGER.info(String.format("Permissions of '%s' added successfully to documents",fileId));
    }

    public void processDownload() {
        try {
            String content = "";
            if (this.metadata != null && (!this.isFolder())) {
                content = String.format("%s@%s", this.metadata.getKey(), this.metadata.getBucket());
                this.sendToParsingService = true;
            }
            else{
                this.sendToParsingService = false;
            }
            document.setContent(content);
        } catch (Exception e) {
            this.errorOccurred();
            multipleExceptions.add(fileId, e.getMessage());
        }
    }

    public boolean canPushToQueue(){
        if(!this.fileExists){
            return false;
        }
        else if((this.elasticOperation == ElasticOperation.CREATE ||
                this.elasticOperation == ElasticOperation.PERMISSIONS_UPDATE) &&
                this.document.getPermissions() == null){
            return false;
        }
        else if(this.elasticOperation == ElasticOperation.METADATA_UPDATE &&
        this.document.getMetadata() == null){
            return false;
        }
        else{
            return true;
        }

    }

    public void pushToQueue(){
        try {
            if (this.sendToParsingService) {
                State.producer.sendToParsingQueue(this.document);
            } else {
                this.setDataTime();
                State.producer.sendToElasticQueue(this.document);
            }

            for(Document descendantDocument : this.descendantDocuments){
                try{
                    State.producer.sendToElasticQueue(descendantDocument);
                }
                catch(Exception e){
                    this.errorOccurred();
                    this.addException(descendantDocument.getFileId(), e.getMessage());
                }
            }
        }
        catch(Exception e){
            this.errorOccurred();
            this.addException(fileId, e.getMessage());
        }
    }

    public void pushToErrorQueue(){
        if(this.getError()){
            for(String id : this.multipleExceptions.fileIdToErrorMessage.keySet()){
                LOGGER.error(String.format("Errors with fileid='%s': %s",id,
                        this.multipleExceptions.getFileIdToErrorMessage().get(id)));
                try{
                    State.producer.sendError(new ErrorMessage(id, ErrorOperation.REFRESH));
                }
                catch(Exception e){
                    LOGGER.error(String.format("Error in pushing fileid='%s' to error queue",id));
                }
            }
        }
    }

    public void pushDeleteError(){
        try{
            State.producer.sendError(new ErrorMessage(this.fileId, ErrorOperation.DELETE));
        }
        catch(Exception e){
            LOGGER.error(String.format("Error in pushing fileid='%s' to error queue",this.fileId));
        }
    }
}
