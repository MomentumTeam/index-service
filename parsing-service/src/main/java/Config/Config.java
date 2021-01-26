package Config;

public class Config {
    
    public static final String RABBIT_URL = (System.getenv("INDUX_RABBIT_URL")!=null) ? System.getenv("INDUX_RABBIT_URL") : "localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("INDUX_EXCHANGE_NAME")!=null) ? System.getenv("INDUX_EXCHANGE_NAME") : "indexService" ;

    public static final String PARSING_SERVICE_QUEUE_NAME = (System.getenv("INDUX_PARSING_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDUX_PARSING_SERVICE_QUEUE_NAME") : "parsingService" ;
    public static final String PARSING_SERVICE_ROUTING_KEY = (System.getenv("INDUX_PARSING_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDUX_PARSING_SERVICE_ROUTING_KEY") : "parsingServiceKey" ;

    public static final String ELASTIC_SERVICE_QUEUE_NAME = (System.getenv("INDUX_ELASTIC_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDUX_ELASTIC_SERVICE_QUEUE_NAME") : "elasticService" ;
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = (System.getenv("INDUX_ELASTIC_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDUX_ELASTIC_SERVICE_ROUTING_KEY") : "elasticServiceKey" ;

    public static final String ERROR_QUEUE_NAME = (System.getenv("INDUX_ERROR_QUEUE_NAME")!=null) ? System.getenv("INDUX_ERROR_QUEUE_NAME") : "error";
    public static final String  ERROR_ROUTING_KEY = (System.getenv("INDUX_ERROR_ROUTING_KEY")!=null) ? System.getenv("INDUX_ERROR_ROUTING_KEY") : "errorKey";

    public static String DRIVE_URL = (System.getenv("INDUX_DRIVE_URL")!=null) ? System.getenv("INDUX_DRIVE_URL") : "40.127.198.131" ;
    public static int DOWNLOAD_SERVICE_PORT = (System.getenv("INDUX_DOWNLOAD_SERVICE_PORT")!=null) ? Integer.parseInt(System.getenv("INDUX_DOWNLOAD_SERVICE_PORT")) : 8082;
    public static int FILE_SERVICE_PORT =  (System.getenv("INDUX_FILE_SERVICE_PORT")!=null) ? Integer.parseInt(System.getenv("INDUX_FILE_SERVICE_PORT")) : 8083;
    public static int USER_SERVICE_PORT = (System.getenv("INDUX_USER_SERVICE_PORT")!=null) ? Integer.parseInt(System.getenv("INDUX_USER_SERVICE_PORT")) : 8086;
    public static String DOWNLOAD_FOLDER_PATH = (System.getenv("INDUX_DOWNLOAD_FOLDER_PATH")!=null) ? System.getenv("INDUX_DOWNLOAD_FOLDER_PATH") : "/home/sraya/IdeaProjects/IndexService/src/main/java/downloadFiles";

    public static int CHUNK_SIZE = (System.getenv("INDUX_CHUNK_SIZE")!=null) ? Integer.parseInt(System.getenv("INDUX_CHUNK_SIZE")) : 1000;
    public static int SUFF_PRE_SIZE = (System.getenv("INDUX_SUFF_PRE_SIZE")!=null) ? Integer.parseInt(System.getenv("INDUX_SUFF_PRE_SIZE")) : 100;
    public static int SUFF_PRE_COUNT_PER_DOCUMENT= CHUNK_SIZE / SUFF_PRE_SIZE;


}
