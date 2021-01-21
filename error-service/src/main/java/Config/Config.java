package Config;

public class Config {

    public static final String RABBIT_URL = System.getenv("RABBIT_URL");
    public static final String EXCHANGE_NAME = System.getenv("EXCHANGE_NAME");


    public static final String  DELETE_QUEUE_NAME = System.getenv("DELETE_QUEUE_NAME");
    public static final String  DELETE_ROUTING_KEY = System.getenv("DELETE_ROUTING_KEY");


    public static final String ERROR_QUEUE_NAME = System.getenv("ERROR_QUEUE_NAME");
    public static final String  ERROR_ROUTING_KEY = System.getenv("ERROR_ROUTING_KEY");

    public static String DRIVE_URL = System.getenv("DRIVE_URL");
    public static int DOWNLOAD_SERVICE_PORT = Integer.parseInt(System.getenv("DOWNLOAD_SERVICE_PORT"));
    public static String DOWNLOAD_FOLDER_PATH = System.getenv("DOWNLOAD_FOLDER_PATH");

    public static int CHUNK_SIZE = Integer.parseInt(System.getenv("CHUNK_SIZE"));;
    public static int PRE_SUFF_SIZE = Integer.parseInt(System.getenv("PRE_SUFF_SIZE"));;
    public static int PRE_SUFF_PARTS_COUNT= CHUNK_SIZE / PRE_SUFF_SIZE;


}
