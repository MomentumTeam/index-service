package Services;

import Config.Config;
import Enums.ErrorOperation;
import Rabbit.Producer;
import RabbitModels.DeleteRequest;
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
        String fileId = message.getFileId();
        ErrorOperation operation = message.getOperation();
        boolean createAfter = false;

        if (operation == ErrorOperation.REFRESH)
            createAfter = true;

        DeleteRequest deleteRequest = new DeleteRequest(fileId, createAfter);

        producer.sendDelete(deleteRequest);

    }

}
