package Config;

import Enums.MessageEvent;

import java.util.HashSet;

public class Config {

    public static final String RABBIT_URL = (System.getenv("INDEXING_RABBIT_URL")!=null) ? System.getenv("INDEXING_RABBIT_URL") : "localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("INDEXING_EXCHANGE_NAME")!=null) ? System.getenv("INDEXING_EXCHANGE_NAME") : "indexService" ;

    public static final String EVENTS_QUEUE_NAME = (System.getenv("INDEXING_EVENTS_QUEUE_NAME")!=null) ? System.getenv("INDEXING_EVENTS_QUEUE_NAME") : "events";
    public static final String  EVENTS_ROUTING_KEY = (System.getenv("INDEXING_EVENTS_ROUTING_KEY")!=null) ? System.getenv("INDEXING_EVENTS_ROUTING_KEY") : "eventsKey";

    public static final String  DELETE_QUEUE_NAME = (System.getenv("INDEXING_DELETE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_DELETE_QUEUE_NAME") : "delete";
    public static final String  DELETE_ROUTING_KEY = (System.getenv("INDEXING_DELETE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_DELETE_ROUTING_KEY") : "deleteKey";

    public static final String DRIVE_SERVICE_QUEUE_NAME = (System.getenv("INDEXING_DRIVE_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_DRIVE_SERVICE_QUEUE_NAME") : "driveService" ;
    public static final String  DRIVE_SERVICE_ROUTING_KEY = (System.getenv("INDEXING_DRIVE_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_DRIVE_SERVICE_ROUTING_KEY") : "driveServiceKey";

    public static final String ERROR_QUEUE_NAME = (System.getenv("INDEXING_ERROR_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ERROR_QUEUE_NAME") : "error" ;
    public static final String  ERROR_ROUTING_KEY = (System.getenv("INDEXING_ERROR_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ERROR_ROUTING_KEY") : "errorKey";

    public static final HashSet<MessageEvent> DELETE_EVENTS = new HashSet<MessageEvent>() {{
        add(MessageEvent.CONTENT_CHANGE);
        add(MessageEvent.DELETE);
    }};
}
