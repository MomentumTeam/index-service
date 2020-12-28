package Config;

public class Config {

    public static final String RABBIT_URL = "localhost";
    public static final String EXCHANGE_NAME = "indexService";

    public static final String PARSING_SERVICE_QUEUE_NAME = "parsingService";
    public static final String  PARSING_SERVICE_ROUTING_KEY = "parsingServiceKey";

    public static final String ELASTIC_SERVICE_QUEUE_NAME = "elasticService";
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = "elasticServiceKey";

    public static final String ERROR_QUEUE_NAME = "error";
    public static final String  ERROR_ROUTING_KEY = "errorKey";

    public static String DRIVE_URL = "13.94.97.244";
    public static int DOWNLOAD_SERVICE_PORT = 8082;
    public static int FILE_SERVICE_PORT = 8083;
    public static String DOWNLOAD_FOLDER_PATH = "/home/sraya/IdeaProjects/IndexService/src/main/java/downloadFiles";

    public static int CHUNK_SIZE = 5000;
    public static int SUFF_PRE_SIZE = 100;
    public static int SUFF_PRE_COUNT_PER_DOCUMENT= CHUNK_SIZE / SUFF_PRE_SIZE;


}
