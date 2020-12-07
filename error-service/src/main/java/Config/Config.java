package Config;

public class Config {

    public static final String RABBIT_URL = "localhost";
    public static final String EXCHANGE_NAME = "indexService";


    public static final String DELETE_QUEUE_NAME = "delete";
    public static final String  DELETE_ROUTING_KEY = "deleteKey";

    public static final String ERROR_QUEUE_NAME = "error";
    public static final String  ERROR_ROUTING_KEY = "errorKey";

    public static String DRIVE_URL = "localhost";
    public static int DOWNLOAD_SERVICE_PORT = 8082;
    public static String DOWNLOAD_FOLDER_PATH = "/home/sraya/IdeaProjects/IndexService/src/main/java/downloadFiles";

    public static int CHUNK_SIZE = 1000;
    public static int PRE_SUFF_SIZE = 100;
    public static int PRE_SUFF_PARTS_COUNT= CHUNK_SIZE / PRE_SUFF_SIZE;


}
