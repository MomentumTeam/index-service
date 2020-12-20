package Services;

import Enums.ElasticOperation;
import Enums.ErrorOperation;
import Models.Document;
import Models.FileMetadata;
import Models.Permission;
import Rabbit.Producer;
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

    public static void processDocument (Document document) throws Exception {
        try {
            document.elasticDo();
        }
        catch(Exception e){
            throw e;
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
