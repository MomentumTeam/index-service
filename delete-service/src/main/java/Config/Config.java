package Config;

import Enums.MessageEvent;

import java.util.Arrays;
import java.util.HashSet;

public class Config {

    public static final int HC_PORT = (System.getenv("INDEXING_DELETE_SERVICE_HC_PORT")!=null)? Integer.parseInt(System.getenv("INDEXING_DELETE_SERVICE_HC_PORT")): 8084;
    public static final String RABBIT_URL = (System.getenv("INDEXING_RABBIT_URL")!=null) ? System.getenv("INDEXING_RABBIT_URL") : "amqp://localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("INDEXING_EXCHANGE_NAME")!=null) ? System.getenv("INDEXING_EXCHANGE_NAME") : "indexService" ;
    public static final int RABBIT_MAX_WAIT_TIME = (System.getenv("RABBIT_MAX_WAIT_TIME")!=null)? Integer.parseInt(System.getenv("RABBIT_MAX_WAIT_TIME")): 300000;

    public static final String EVENTS_QUEUE_NAME = (System.getenv("INDEXING_EVENTS_QUEUE_NAME")!=null) ? System.getenv("INDEXING_EVENTS_QUEUE_NAME") : "events";
    public static final String  EVENTS_ROUTING_KEY = (System.getenv("INDEXING_EVENTS_ROUTING_KEY")!=null) ? System.getenv("INDEXING_EVENTS_ROUTING_KEY") : "eventsKey";

    public static final String  DELETE_QUEUE_NAME = (System.getenv("INDEXING_DELETE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_DELETE_QUEUE_NAME") : "delete" ;
    public static final String  DELETE_ROUTING_KEY = (System.getenv("INDEXING_DELETE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_DELETE_ROUTING_KEY") : "deleteKey";

    public static final String ERROR_QUEUE_NAME = (System.getenv("INDEXING_ERROR_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ERROR_QUEUE_NAME") : "error";
    public static final String  ERROR_ROUTING_KEY = (System.getenv("INDEXING_ERROR_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ERROR_ROUTING_KEY") : "errorKey" ;

    public static final String[] ELASTIC_URLS = (System.getenv("INDEXING_ELASTIC_URLS")!=null) ?
            Arrays.asList(System.getenv("INDEXING_ELASTIC_URLS").split(",")).stream().toArray(String[]::new)
            :  Arrays.asList("http://13.70.205.201:9200".split(",")).stream().toArray(String[]::new);
}