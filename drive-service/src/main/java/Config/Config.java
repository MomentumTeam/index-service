package Config;
public class Config {

    public static final String RABBIT_URL = (System.getenv("INDEXING_RABBIT_URL")!=null) ? System.getenv("INDEXING_RABBIT_URL") : "localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("INDEXING_EXCHANGE_NAME")!=null) ? System.getenv("INDEXING_EXCHANGE_NAME") : "indexService" ;

    public static final String EVENTS_QUEUE_NAME = (System.getenv("INDEXING_EVENTS_QUEUE_NAME")!=null) ? System.getenv("INDEXING_EVENTS_QUEUE_NAME") : "events";
    public static final String  EVENTS_ROUTING_KEY = (System.getenv("INDEXING_EVENTS_ROUTING_KEY")!=null) ? System.getenv("INDEXING_EVENTS_ROUTING_KEY") : "eventsKey";

    public static final String DRIVE_SERVICE_QUEUE_NAME = (System.getenv("INDEXING_DRIVE_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_DRIVE_SERVICE_QUEUE_NAME") : "driveService" ;
    public static final String  DRIVE_SERVICE_ROUTING_KEY = (System.getenv("INDEXING_DRIVE_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_DRIVE_SERVICE_ROUTING_KEY") : "driveServiceKey";

    public static final String ERROR_QUEUE_NAME = (System.getenv("INDEXING_ERROR_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ERROR_QUEUE_NAME") : "error" ;
    public static final String  ERROR_ROUTING_KEY = (System.getenv("INDEXING_ERROR_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ERROR_ROUTING_KEY") : "errorKey";

    public static final String PARSING_SERVICE_QUEUE_NAME = (System.getenv("INDEXING_PARSING_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_PARSING_SERVICE_QUEUE_NAME") : "parsingService";
    public static final String PARSING_SERVICE_ROUTING_KEY = (System.getenv("INDEXING_PARSING_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_PARSING_SERVICE_ROUTING_KEY") : "parsingServiceKey";

    public static final String ELASTIC_SERVICE_QUEUE_NAME = (System.getenv("INDEXING_ELASTIC_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ELASTIC_SERVICE_QUEUE_NAME") : "elasticService" ;
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = (System.getenv("INDEXING_INDEXING_PARSING_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_PARSING_SERVICE_ROUTING_KEY") : "elasticServiceKey" ;

    public static String FOLDER_TYPE = (System.getenv("INDEXING_PARSING_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_PARSING_SERVICE_ROUTING_KEY") : "parsingServiceKey";

    public static String FILE_SERVICE_URL = (System.getenv("INDEXING_FILE_SERVICE_URL")!=null) ? System.getenv("INDEXING_FILE_SERVICE_URL") : "40.127.198.131:8083";
    public static String PERMISSION_SERVICE_URL = (System.getenv("INDEXING_PERMISSION_SERVICE_URL")!=null) ? System.getenv("INDEXING_PERMISSION_SERVICE_URL") : "40.127.198.131:8087";
    public static String USER_SERVICE_URL = (System.getenv("INDEXING_USER_SERVICE_URL")!=null) ? System.getenv("INDEXING_USER_SERVICE_URL") : "40.127.198.131:8086";
}
