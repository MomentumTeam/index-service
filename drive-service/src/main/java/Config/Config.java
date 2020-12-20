package Config;

import java.util.HashSet;

public class Config {

    public static final String RABBIT_URL = "localhost";
    public static final String EXCHANGE_NAME = "indexService";


    public static final String EVENTS_QUEUE_NAME = "events";
    public static final String  EVENTS_ROUTING_KEY = "eventsKey";

    public static final String PARSING_SERVICE_QUEUE_NAME = "parsingService";
    public static final String  PARSING_SERVICE_ROUTING_KEY = "parsingServiceKey";

    public static final String DRIVE_SERVICE_QUEUE_NAME = "driveService";
    public static final String  DRIVE_SERVICE_ROUTING_KEY = "driveServiceKey";

    public static final String ELASTIC_SERVICE_QUEUE_NAME = "elasticService";
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = "elasticServiceKey";

    public static final String ERROR_QUEUE_NAME = "error";
    public static final String  ERROR_ROUTING_KEY = "errorKey";

    public static String DRIVE_URL = "localhost";
    public static int DOWNLOAD_SERVICE_PORT = 8082;
    public static int FILE_SERVICE_PORT = 8083;
    public static int USER_SERVICE_PORT = 8086;
    public static int PERMISSION_SERVICE_PORT = 8087;
    public static String DOWNLOAD_FOLDER_PATH = "/home/sraya/Desktop/index-service/drive-service/src/main/java/downloads";



}
