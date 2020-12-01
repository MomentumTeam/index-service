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

    public static void sendError(String fileId, ErrorOperation operation) throws Exception {
        try{
            producer.sendError(new ErrorMessage(fileId , operation));
        }
        catch(Exception exception){
            throw exception;
        }
    }
}
