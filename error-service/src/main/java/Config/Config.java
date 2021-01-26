package Config;

public class Config {

    public static final String RABBIT_URL = (System.getenv("RABBIT_URL")!=null) ? System.getenv("RABBIT_URL") : "localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("EXCHANGE_NAME")!=null) ? System.getenv("EXCHANGE_NAME") : "indexService" ;

    public static final String  DELETE_QUEUE_NAME = (System.getenv("DELETE_QUEUE_NAME")!=null) ? System.getenv("DELETE_QUEUE_NAME") : "delete" ;
    public static final String  DELETE_ROUTING_KEY = (System.getenv("DELETE_ROUTING_KEY")!=null) ? System.getenv("DELETE_ROUTING_KEY") : "deleteKey"  ;

    public static final String ERROR_QUEUE_NAME = (System.getenv("ERROR_QUEUE_NAME")!=null) ? System.getenv("ERROR_QUEUE_NAME") : "error" ;
    public static final String  ERROR_ROUTING_KEY = (System.getenv("ERROR_ROUTING_KEY")!=null) ? System.getenv("ERROR_ROUTING_KEY") : "errorKey" ;

    public static String DRIVE_URL = (System.getenv("DRIVE_URL")!=null) ? System.getenv("DRIVE_URL") : "40.127.198.131";
    public static int DOWNLOAD_SERVICE_PORT = (System.getenv("DOWNLOAD_SERVICE_PORT")!=null) ? Integer.parseInt(System.getenv("DOWNLOAD_SERVICE_PORT")) : 8082;
    public static String DOWNLOAD_FOLDER_PATH = (System.getenv("DOWNLOAD_FOLDER_PATH")!=null) ? System.getenv("DOWNLOAD_FOLDER_PATH") : "/home/sraya/IdeaProjects/IndexService/src/main/java/downloadFiles";

    public static int CHUNK_SIZE = (System.getenv("CHUNK_SIZE")!=null) ? Integer.parseInt(System.getenv("CHUNK_SIZE")) : 1000;
    public static int PRE_SUFF_SIZE = (System.getenv("PRE_SUFF_SIZE")!=null) ? Integer.parseInt(System.getenv("PRE_SUFF_SIZE")) : 100;
    public static int PRE_SUFF_PARTS_COUNT= CHUNK_SIZE / PRE_SUFF_SIZE;


}
