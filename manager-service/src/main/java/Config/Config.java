package Config;

import Enums.MessageEvent;

import java.util.HashSet;

public class Config {

    public static final String RABBIT_URL = System.getenv("RABBIT_URL");
    public static final String EXCHANGE_NAME = System.getenv("EXCHANGE_NAME");


    public static final String EVENTS_QUEUE_NAME = System.getenv("EVENTS_QUEUE_NAME");
    public static final String  EVENTS_ROUTING_KEY = System.getenv("EVENTS_ROUTING_KEY");

    public static final String  DELETE_QUEUE_NAME = System.getenv("DELETE_QUEUE_NAME");
    public static final String  DELETE_ROUTING_KEY = System.getenv("DELETE_ROUTING_KEY");

    public static final String DRIVE_SERVICE_QUEUE_NAME = System.getenv("DRIVE_SERVICE_QUEUE_NAME");
    public static final String  DRIVE_SERVICE_ROUTING_KEY = System.getenv("DRIVE_SERVICE_ROUTING_KEY");

    public static final String ERROR_QUEUE_NAME = System.getenv("ERROR_QUEUE_NAME");
    public static final String  ERROR_ROUTING_KEY = System.getenv("ERROR_ROUTING_KEY");

    public static final HashSet<MessageEvent> DELETE_EVENTS = new HashSet<MessageEvent>() {{
        add(MessageEvent.CONTENT_CHANGE);
        add(MessageEvent.DELETE);
    }};
}
