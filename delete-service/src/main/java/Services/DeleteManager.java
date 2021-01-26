package Services;

import Enums.ErrorOperation;
import Enums.MessageEvent;
import Models.DeleteRequest;
import Models.DriveEventMessage;
import Models.ErrorMessage;
import Rabbit.Producer;

public class DeleteManager {

    public static Producer producer;

    static {
        try {
            producer = new Producer();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void processMessage (DeleteRequest message) throws Exception {
        try {
            String fileId = message.getFileId();
            ElasticService.delete(fileId, "*");
        }
        catch(Exception exception){
            throw exception;
        }
    }

    public static void sendError(String fileId , ErrorOperation operation) throws Exception {
        try{
            producer.sendError(new ErrorMessage(fileId , operation));
        }
        catch(Exception exception){
            throw exception;
        }
    }
}
