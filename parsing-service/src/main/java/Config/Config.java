package Config;

public class Config {

    // public static final String RABBIT_URL = "localhost";
    // public static final String EXCHANGE_NAME = "indexService";

    // public static final String PARSING_SERVICE_QUEUE_NAME = "parsingService";
    // public static final String  PARSING_SERVICE_ROUTING_KEY = "parsingServiceKey";

    // public static final String ELASTIC_SERVICE_QUEUE_NAME = "elasticService";
    // public static final String  ELASTIC_SERVICE_ROUTING_KEY = "elasticServiceKey";

    // public static final String ERROR_QUEUE_NAME = "error";
    // public static final String  ERROR_ROUTING_KEY = "errorKey";

    // public static String DRIVE_URL = "40.127.198.131";
    // public static int DOWNLOAD_SERVICE_PORT = 8082;
    // public static int FILE_SERVICE_PORT = 8083;
    // public static String DOWNLOAD_FOLDER_PATH = "/home/sraya/IdeaProjects/IndexService/src/main/java/downloadFiles";

    // public static int CHUNK_SIZE = 5000;
    // public static int SUFF_PRE_SIZE = 100;

    public static final String RABBIT_URL = System.getenv("RABBIT_URL");
    public static final String EXCHANGE_NAME = System.getenv("EXCHANGE_NAME");

    public static final String PARSING_SERVICE_QUEUE_NAME = System.getenv("PARSING_SERVICE_QUEUE_NAME");
    public static final String PARSING_SERVICE_ROUTING_KEY = System.getenv("PARSING_SERVICE_ROUTING_KEY");

    public static final String ELASTIC_SERVICE_QUEUE_NAME = System.getenv("ELASTIC_SERVICE_QUEUE_NAME");
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = System.getenv("ELASTIC_SERVICE_ROUTING_KEY");

    public static final String ERROR_QUEUE_NAME = System.getenv("ERROR_QUEUE_NAME");
    public static final String  ERROR_ROUTING_KEY = System.getenv("ERROR_ROUTING_KEY");

    // public static String DRIVE_URL = "40.127.198.131";
    // public static int DOWNLOAD_SERVICE_PORT = 8082;
    // public static int FILE_SERVICE_PORT = 8083;
    // public static String DOWNLOAD_FOLDER_PATH = "/home/sraya/IdeaProjects/IndexService/src/main/java/downloadFiles";
    public static String DRIVE_URL = System.getenv("DRIVE_URL");
    public static int DOWNLOAD_SERVICE_PORT = Integer.parseInt(System.getenv("DOWNLOAD_SERVICE_PORT"));
    public static int FILE_SERVICE_PORT =  Integer.parseInt(System.getenv("FILE_SERVICE_PORT"));
    public static int USER_SERVICE_PORT = Integer.parseInt(System.getenv("USER_SERVICE_PORT"));
    public static String DOWNLOAD_FOLDER_PATH = System.getenv("DOWNLOAD_FOLDER_PATH");

    public static int CHUNK_SIZE = Integer.parseInt(System.getenv("CHUNK_SIZE"));
    public static int SUFF_PRE_SIZE = Integer.parseInt(System.getenv("SUFF_PRE_SIZE"));
    public static int SUFF_PRE_COUNT_PER_DOCUMENT= CHUNK_SIZE / SUFF_PRE_SIZE;


}
