package Config;

public class Config {

    public static final String RABBIT_URL = "localhost";
    public static final String EXCHANGE_NAME = "indexService";

    public static final String ELASTIC_SERVICE_QUEUE_NAME = "elasticService";
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = "elasticServiceKey";

    public static final String ERROR_QUEUE_NAME = "error";
    public static final String  ERROR_ROUTING_KEY = "errorKey";

    public static String ELASTIC_HOST = "52.169.31.99";
    public static int ELASTIC_PORT = 9200;
    public static String ELASTIC_PROTOCOL = "http";

}
