package Services;

import Enums.DriveField;
import Enums.ElasticOperation;
import Enums.ErrorOperation;
import Exceptions.MultipleExceptions;
import Models.State;
import Rabbit.Producer;
import RabbitModels.DriveRequest;
import RabbitModels.ErrorMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static void processData (DriveRequest message) {
        String fileId = message.getFileId();
        ElasticOperation elasticOperation = message.elasticOperation;
        DriveField[] driveFields = message.getDriveFields();

        State state = new State(fileId, elasticOperation);
        state.receiveMetadata();

        for (DriveField field: driveFields) {
            switch (field) {
                case METADATA:
                    state.processMetadata();
                    break;
                case PERMISSIONS:
                    state.processPermissions();
                    break;
                case DOWNLOAD:
                    state.processDownload();
            }
        }

        if(state.canPushToElasticQueue()){
            state.pushToElasticQueue();
        }
        state.pushToErrorQueue();
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
