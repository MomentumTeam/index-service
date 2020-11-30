package Services;

import Config.Config;
import Enums.DriveField;
import Enums.MessageEvent;
import Models.DeleteRequest;
import Models.DriveEventMessage;
import Models.DriveRequest;
import Models.RabbitErrorMassage;
import Rabbit.Producer;
import com.rabbitmq.client.AMQP;

import java.text.ParseException;

public class Manager {

    public static Producer producer;

    static {
        try {
            producer = new Producer();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void processMessage (DriveEventMessage message) throws Exception {
        try {
            MessageEvent event = message.getEvent();
            String fileId = message.getFileId();
            if (Config.DELETE_EVENTS.contains(event)) {
                boolean createAfter = false;
                if (event == MessageEvent.CONTENT_CHANGE) {
                    createAfter = true;
                }
                DeleteRequest deleteRequest = new DeleteRequest(fileId, createAfter);
                producer.sendDelete(deleteRequest);
            } else {
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
            }
        }
        catch(Exception exception){
            throw exception;
        }
    }

    public static void sendError(String fileId) throws Exception {
        try{
            producer.sendError(new RabbitErrorMassage(fileId));
        }
        catch(Exception exception){
            throw exception;
        }
    }
}
