package Config;

import java.util.HashSet;

public class Config {

    // public static final String RABBIT_URL = "localhost";
    // public static final String EXCHANGE_NAME = "indexService";
    public static final String RABBIT_URL = System.getenv("RABBIT_URL");
    public static final String EXCHANGE_NAME = System.getenv("EXCHANGE_NAME");

    // public static final String EVENTS_QUEUE_NAME = "events";
    // public static final String  EVENTS_ROUTING_KEY = "eventsKey";
    public static final String EVENTS_QUEUE_NAME = System.getenv("EVENTS_QUEUE_NAME");
    public static final String  EVENTS_ROUTING_KEY = System.getenv("EVENTS_ROUTING_KEY");

    // public static final String DRIVE_SERVICE_QUEUE_NAME = "driveService";
    // public static final String  DRIVE_SERVICE_ROUTING_KEY = "driveServiceKey";
    public static final String DRIVE_SERVICE_QUEUE_NAME = System.getenv("DRIVE_SERVICE_QUEUE_NAME");
    public static final String  DRIVE_SERVICE_ROUTING_KEY = System.getenv("DRIVE_SERVICE_ROUTING_KEY");

    // public static final String ERROR_QUEUE_NAME = "error";
    // public static final String  ERROR_ROUTING_KEY = "errorKey";
    public static final String ERROR_QUEUE_NAME = System.getenv("ERROR_QUEUE_NAME");
    public static final String  ERROR_ROUTING_KEY = System.getenv("ERROR_ROUTING_KEY");

    // public static final String PARSING_SERVICE_QUEUE_NAME = "parsingService";
    // public static final String  PARSING_SERVICE_ROUTING_KEY = "parsingServiceKey";
    public static final String PARSING_SERVICE_QUEUE_NAME = System.getenv("PARSING_SERVICE_QUEUE_NAME");
    public static final String PARSING_SERVICE_ROUTING_KEY = System.getenv("PARSING_SERVICE_ROUTING_KEY");

    // public static String DRIVE_URL = "40.127.198.131";
    // public static int DOWNLOAD_SERVICE_PORT = 8082;
    // public static int FILE_SERVICE_PORT = 8083;
    // public static int USER_SERVICE_PORT = 8086;
    // public static int PERMISSION_SERVICE_PORT = 8087;
    // public static String FOLDER_TYPE = "application/vnd.drive.folder";
    public static final String ELASTIC_SERVICE_QUEUE_NAME = System.getenv("ELASTIC_SERVICE_QUEUE_NAME");
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = System.getenv("ELASTIC_SERVICE_ROUTING_KEY");

    public static String DRIVE_URL = System.getenv("DRIVE_URL");
    public static int DOWNLOAD_SERVICE_PORT = Integer.parseInt(System.getenv("DOWNLOAD_SERVICE_PORT"));
    public static int FILE_SERVICE_PORT =  Integer.parseInt(System.getenv("FILE_SERVICE_PORT"));
    public static int USER_SERVICE_PORT = Integer.parseInt(System.getenv("USER_SERVICE_PORT"));
    public static int PERMISSION_SERVICE_PORT = Integer.parseInt(System.getenv("PERMISSION_SERVICE_PORT"));

    public static String FOLDER_TYPE = System.getenv("PARSING_SERVICE_ROUTING_KEY");
}
