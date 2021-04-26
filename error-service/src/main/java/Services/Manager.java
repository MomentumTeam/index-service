package Services;

import Enums.ErrorOperation;
import Enums.MessageEvent;
import Rabbit.Producer;
import RabbitModels.DriveEventMessage;
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

    public static void processError (ErrorMessage message) throws Exception {
        try{
            String fileId = message.getFileId();
            ErrorOperation operation = message.getOperation();
            MessageEvent event = operation == ErrorOperation.REFRESH ? MessageEvent.CREATE : MessageEvent.DELETE;
            DriveEventMessage driveEventMessage = new DriveEventMessage(fileId , event);
            producer.sendEvent(driveEventMessage);
        }
        catch(Exception e){
            throw e;
        }

    }

}
