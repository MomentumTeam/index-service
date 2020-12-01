package Services;

import Config.Config;
import Enums.DriveField;
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
            if (Config.DELETE_EVENTS.contains(event)) {
                try {
                    boolean createAfter = false;
                    if (event == MessageEvent.CONTENT_CHANGE) {
                        createAfter = true;
                    }
                    DeleteRequest deleteRequest = new DeleteRequest(fileId, createAfter);
                    producer.sendDelete(deleteRequest);
                }
                catch(Exception exception){
                    throw new DeleteException(exception.getMessage());
                }
            } else {
                try {
                    DriveField[] fields;
                    switch (event) {
                        case CREATE:
                            fields = new DriveField[]{DriveField.PERMISSIONS, DriveField.DOWNLOAD, DriveField.METADATA};
                            break;
                        case METADATA_CHANGE:
                            fields = new DriveField[]{DriveField.METADATA};
                            break;
                        default: //PERMISSION_CHANGE
                            fields = new DriveField[]{DriveField.PERMISSIONS};
                            break;
                    }
                    DriveRequest driveRequest = new DriveRequest(fileId, fields);
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
