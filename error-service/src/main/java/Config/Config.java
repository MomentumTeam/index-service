package Config;

import java.time.LocalTime;

public class Config {

    public static final int HC_PORT = (System.getenv("INDEXING_ERROR_SERVICE_HC_PORT")!=null)? Integer.parseInt(System.getenv("INDEXING_ERROR_SERVICE_HC_PORT")): 8085;
    public static final int RABBIT_MAX_WAIT_TIME = (System.getenv("RABBIT_MAX_WAIT_TIME")!=null)? Integer.parseInt(System.getenv("RABBIT_MAX_WAIT_TIME")): 300000;

    public static final String startTimeString = (System.getenv("INDEXING_ERROR_SERVICE_START_TIME")!=null) ? System.getenv("INDEXING_ERROR_SERVICE_START_TIME") : "12:00" ;
    public static final String endTimeString = (System.getenv("INDEXING_ERROR_SERVICE_END_TIME")!=null) ? System.getenv("INDEXING_ERROR_SERVICE_END_TIME") : "12:10" ;

    public static final LocalTime startTime = LocalTime.parse(startTimeString);
    public static final LocalTime endTime = LocalTime.parse(endTimeString);
    public static final String RABBIT_URL = (System.getenv("INDEXING_RABBIT_URL")!=null) ? System.getenv("INDEXING_RABBIT_URL") : "amqp://localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("INDEXING_EXCHANGE_NAME")!=null) ? System.getenv("INDEXING_EXCHANGE_NAME") : "indexService" ;

    public static final String EVENTS_QUEUE_NAME = (System.getenv("INDEXING_EVENTS_QUEUE_NAME")!=null) ? System.getenv("INDEXING_EVENTS_QUEUE_NAME") : "events";
    public static final String  EVENTS_ROUTING_KEY = (System.getenv("INDEXING_EVENTS_ROUTING_KEY")!=null) ? System.getenv("INDEXING_EVENTS_ROUTING_KEY") : "eventsKey";

    public static final String ERROR_QUEUE_NAME = (System.getenv("INDEXING_ERROR_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ERROR_QUEUE_NAME") : "error" ;
    public static final String  ERROR_ROUTING_KEY = (System.getenv("INDEXING_ERROR_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ERROR_ROUTING_KEY") : "errorKey";

}
