package Config;

import Enums.MessageEvent;

import java.util.HashSet;

public class Config {


    public static final String RABBIT_URL = (System.getenv("RABBIT_URL")!=null) ? System.getenv("RABBIT_URL") : "localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("EXCHANGE_NAME")!=null) ? System.getenv("EXCHANGE_NAME") : "indexService" ;

    public static final String EVENTS_QUEUE_NAME = (System.getenv("EVENTS_QUEUE_NAME")!=null) ? System.getenv("EVENTS_QUEUE_NAME") : "events";
    public static final String  EVENTS_ROUTING_KEY = (System.getenv("EVENTS_ROUTING_KEY")!=null) ? System.getenv("EVENTS_ROUTING_KEY") : "eventsKey";

    public static final String  DELETE_QUEUE_NAME = (System.getenv("DELETE_QUEUE_NAME")!=null) ? System.getenv("DELETE_QUEUE_NAME") : "delete" ;
    public static final String  DELETE_ROUTING_KEY = (System.getenv("DELETE_ROUTING_KEY")!=null) ? System.getenv("DELETE_ROUTING_KEY") : "deleteKey";

    public static final String DRIVE_SERVICE_QUEUE_NAME = (System.getenv("DRIVE_SERVICE_QUEUE_NAME")!=null) ? System.getenv("DRIVE_SERVICE_QUEUE_NAME") : "driveService" ;
    public static final String  DRIVE_SERVICE_ROUTING_KEY = (System.getenv("DRIVE_SERVICE_ROUTING_KEY")!=null) ? System.getenv("DRIVE_SERVICE_ROUTING_KEY") : "driveServiceKey";

    public static final String ERROR_QUEUE_NAME = (System.getenv("ERROR_QUEUE_NAME")!=null) ? System.getenv("ERROR_QUEUE_NAME") : "error";
    public static final String  ERROR_ROUTING_KEY = (System.getenv("ERROR_ROUTING_KEY")!=null) ? System.getenv("ERROR_ROUTING_KEY") : "errorKey" ;

    public static final HashSet<MessageEvent> DELETE_EVENTS = new HashSet<MessageEvent>() {{
        add(MessageEvent.CONTENT_CHANGE);
        add(MessageEvent.DELETE);
    }};


    public static final String ELASTIC_HOST = (System.getenv("ELASTIC_HOST")!=null) ? System.getenv("ELASTIC_HOST") : "40.127.198.131" ;
    public static final int ELASTIC_PORT = (System.getenv("ELASTIC_PORT")!=null) ? Integer.parseInt(System.getenv("ELASTIC_PORT")) : 9200;
    public static final String ELASTIC_PROTOCOL = (System.getenv("ELASTIC_PROTOCOL")!=null) ? System.getenv("ELASTIC_PROTOCOL") : "http";
}
