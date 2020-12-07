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
            String fileId = document.getFileId();
            FileMetadata metadata = document.getMetadata();
            Permission[] permissions = document.getPermissions();
            ElasticOperation operation = document.getElasticOperation();
            String path = document.getContent();

            String content = ParsingService.getContent(path);
            content = ParsingService.cleanContent(content);
//            FileService.deleteFile(path);
            String[] chunks = ChunkService.getChunks(content);
            for (String chunk : chunks) {
                Document chunkDocument = new Document(fileId, metadata, permissions, chunk, operation);
                producer.sendToElasticQueue(chunkDocument);
            }

            String[] suffixPrefixArray = ChunkService.getSuffixPrefixStringArray(content);

            for (String suffixPrefix : suffixPrefixArray) {
                Document suffixPrefixDocument = new Document(fileId, metadata, permissions, suffixPrefix, operation);
                producer.sendToElasticQueue(suffixPrefixDocument);
            }
        }
        catch(Exception e){
            try{
                producer.sendToElasticQueue(document);
                FileService.deleteFile(document.getContent());
                throw new Exception();
            }
            catch(Exception error){
                throw error;
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
