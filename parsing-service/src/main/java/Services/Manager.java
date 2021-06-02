package Services;

import Config.Config;
import Enums.ElasticOperation;
import Enums.ErrorOperation;
import Models.Document;
import Models.FileMetadata;
import Models.Permission;
import Rabbit.Producer;
import RabbitModels.ErrorMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Manager {
    private static final Logger LOGGER = LogManager.getLogger(Manager.class);
    public static Producer producer;

    static {
        try {
            producer = new Producer();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void processDocument (Document document) throws Exception {
        String fileId = document.getFileId();
        FileMetadata metadata = document.getMetadata();
        Permission[] permissions = document.getPermissions();
        ElasticOperation operation = document.getElasticOperation();
        String key = document.getContent().split("@")[0];
        String bucket = document.getContent().split("@")[1];
        String content;
        boolean error = false;
        String errorMessage= "";
        byte [] fileArray;
        String[] chunks;
        String[] suffixPrefixArray;

        try{
            fileArray = DataService.download(key, bucket);
            content = Config.SUPPORTED_TYPES.contains(metadata.getType()) ? ParsingService.getContent(fileArray) : "";
            content = ParsingService.cleanContent(content);
            chunks = ChunkService.getChunks(content);
            suffixPrefixArray = ChunkService.getSuffixPrefixStringArray(content);
        }
        catch(Exception e){
            error = true;
            errorMessage = e.getMessage();
            chunks = new String[]{""};
            suffixPrefixArray = new String[0];
        }

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataTime = dateFormat.format(date);
        document.setDataTime(dataTime);

        try{
            for (String chunk : chunks) {
                Document chunkDocument = new Document(fileId, metadata, permissions, chunk, operation,dataTime);
                producer.sendToElasticQueue(chunkDocument);
            }
            for (String suffixPrefix : suffixPrefixArray) {
                Document suffixPrefixDocument = new Document(fileId, metadata, permissions, suffixPrefix, operation, dataTime);
                producer.sendToElasticQueue(suffixPrefixDocument);
            }
            LOGGER.info(String.format("All documents of fileId='%s' were sent to " +
                    "elastic queue successfully", fileId));
        }
        catch(Exception e){
            error = true;
            errorMessage = errorMessage + e.getMessage();
        }
        if(error && metadata != null && Config.SUPPORTED_TYPES.contains(metadata.getType())){
            throw new Exception(errorMessage);
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
