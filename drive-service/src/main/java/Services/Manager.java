package Services;

import Config.Config;
import Enums.DriveField;
import Enums.ElasticOperation;
import Enums.ErrorOperation;
import Models.Document;
import Models.FileMetadata;
import Models.Permission;
import Rabbit.Producer;
import RabbitModels.DriveRequest;
import RabbitModels.ErrorMessage;

public class Manager {

    public static Producer producer;

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
        FileMetadata metadata;
        Permission [] permissions;
        String path;

        Document document = new Document(fileId , operation);
        boolean sendToParsingService = false;
        boolean error = false;

        for (DriveField field: driveFields)
        {
            switch (field) {
                case METADATA:
                    try{
                        metadata = FileMetadata.getMetadata(fileId);
                        document.setMetadata(metadata);
                    }
                    catch(Exception e){
                        error = true;
                    }
                    break;
                case PERMISSIONS:
                    try{
                        permissions = Permission.getPermissions(fileId);
                        document.setPermissions(permissions);
                    }
                    catch(Exception e){
                        if(operation == ElasticOperation.CREATE){
                            throw e;
                        }
                    }
                    break;
                case DOWNLOAD:
                    try{
                        path = DataService.download(fileId, Config.DOWNLOAD_FOLDER_PATH);
                        document.setContent(path);
                        sendToParsingService = true;
                    }
                    catch(Exception e){
                        error = true;
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
            throw new Exception("error");
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
