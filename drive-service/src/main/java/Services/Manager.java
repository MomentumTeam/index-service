package Services;

import Config.Config;
import Enums.DriveField;
import Enums.ElasticOperation;
import Enums.ErrorOperation;
import Models.Document;
import Models.FileMetadata;
import Models.Permission;
import Rabbit.Consumer;
import Rabbit.Producer;
import RabbitModels.DriveRequest;
import RabbitModels.ErrorMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Manager {

    public static Producer producer;
    private static final Logger LOGGER = LogManager.getLogger(Manager.class);

    static {
        try {
            producer = new Producer();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void processData (DriveRequest message) throws Exception {
        String fileId = message.getFileId();
        DriveField[] driveFields = message.getDriveFields();
        ElasticOperation operation = message.getElasticOperation();
        FileMetadata metadata = null;
        Permission [] permissions;

        Document document = new Document(fileId , operation);
        boolean sendToParsingService = false;
        boolean error = false;
        String errorMessage = "", content="";

        for (DriveField field: driveFields)
        {
            switch (field) {
                case METADATA:
                    try{
                        metadata = FileMetadata.getMetadata(fileId);
                        document.setMetadata(metadata);
                        LOGGER.info(String.format("Metadata of '%s' added successfully to document",fileId));
                    }
                    catch(Exception e){
                        error = true;
                        errorMessage = e.getMessage();
                    }
                    break;
                case PERMISSIONS:
                    try{
                        permissions = Permission.getPermissions(fileId);
                        document.setPermissions(permissions);
                        LOGGER.info(String.format("Permissions of '%s' added successfully to document",fileId));
                    }
                    catch(Exception e){
                        if(operation == ElasticOperation.CREATE){
                            throw e;
                        }
                    }
                    break;
                case DOWNLOAD:
                    try{
                        if (!error && metadata != null){ //enough to check one of the condition
                            if(!metadata.getType().equals(Config.FOLDER_TYPE)){
                                content = String.format("%s@%s", metadata.getKey(), metadata.getBucket());
                                sendToParsingService = true;
                            }
                            document.setContent(content);
                        }
                    }
                    catch(Exception e){
                        error = true;
                        errorMessage = errorMessage + e.getMessage();
                        sendToParsingService = false;
                    }
                    break;
            }
        }

        try {
            if (sendToParsingService) {
                producer.sendToParsingQueue(document);
            } else {
                producer.sendToElasticQueue(document);
            }
        }
        catch(Exception e){
            error = true;
        }

        if(error){
            throw new Exception(errorMessage);
        }
    }

    public static void sendError(String fileId, ErrorOperation operation) throws Exception {
        try{
            producer.sendError(new ErrorMessage(fileId , operation));
        }
        catch(Exception exception){
            throw exception;
        }
    }
}
