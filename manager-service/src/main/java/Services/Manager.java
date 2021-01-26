package Services;

import Config.Config;
import Enums.DriveField;
import Enums.ElasticOperation;
import Enums.ErrorOperation;
import Enums.MessageEvent;
import Exceptions.CreateUpdateException;
import Exceptions.DeleteException;
import Models.DeleteRequest;
import Models.DriveEventMessage;
import Models.DriveRequest;
import Models.ErrorMessage;
import Rabbit.Producer;

public class Manager {

    public static Producer producer;

    static {
        try {
            producer = new Producer();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void processMessage (DriveEventMessage message) throws DeleteException,CreateUpdateException {
            MessageEvent event = message.getEvent();
            String fileId = message.getFileId();
            if (event == MessageEvent.DELETE) {
                try {
                    DeleteRequest deleteRequest = new DeleteRequest(fileId);
                    producer.sendDelete(deleteRequest);
                }
                catch(Exception exception){
                    throw new DeleteException(exception.getMessage());
                }
            } else {
                try {
                    DriveField[] fields;
                    ElasticOperation elasticOperation;
                    switch (event) {
                        case CREATE:
                        case CONTENT_CHANGE:
                            fields = new DriveField[]{DriveField.METADATA, DriveField.PERMISSIONS, DriveField.DOWNLOAD};
                            elasticOperation = ElasticOperation.CREATE;
                            break;
                        case METADATA_CHANGE:
                            fields = new DriveField[]{DriveField.METADATA};
                            elasticOperation = ElasticOperation.METADATA_UPDATE;
                            break;
                        default: //PERMISSION_CHANGE
                            fields = new DriveField[]{DriveField.PERMISSIONS};
                            elasticOperation = ElasticOperation.PERMISSIONS_UPDATE;
                            break;
                    }
                    DriveRequest driveRequest = new DriveRequest(fileId, fields,elasticOperation);
                    producer.sendDriveRequest(driveRequest);
                } catch (Exception exception) {
                    throw new CreateUpdateException(exception.getMessage());
                }
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
