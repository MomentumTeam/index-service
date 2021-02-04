package Config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Config {

    public static final String RABBIT_URL = (System.getenv("INDEXING_RABBIT_URL")!=null) ? System.getenv("INDEXING_RABBIT_URL") : "amqp://localhost" ;
    public static final String EXCHANGE_NAME = (System.getenv("INDEXING_EXCHANGE_NAME")!=null) ? System.getenv("INDEXING_EXCHANGE_NAME") : "indexService" ;

    public static final String PARSING_SERVICE_QUEUE_NAME = (System.getenv("INDEXING_PARSING_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_PARSING_SERVICE_QUEUE_NAME") : "parsingService" ;
    public static final String PARSING_SERVICE_ROUTING_KEY = (System.getenv("INDEXING_PARSING_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_PARSING_SERVICE_ROUTING_KEY") : "parsingServiceKey" ;

    public static final String ELASTIC_SERVICE_QUEUE_NAME = (System.getenv("INDEXING_ELASTIC_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ELASTIC_SERVICE_QUEUE_NAME") : "elasticService" ;
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = (System.getenv("INDEXING_ELASTIC_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ELASTIC_SERVICE_ROUTING_KEY") : "elasticServiceKey" ;

    public static final String ERROR_QUEUE_NAME = (System.getenv("INDEXING_ERROR_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ERROR_QUEUE_NAME") : "error";
    public static final String  ERROR_ROUTING_KEY = (System.getenv("INDEXING_ERROR_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ERROR_ROUTING_KEY") : "errorKey";

//    public static String DRIVE_URL = (System.getenv("INDEXING_DRIVE_URL")!=null) ? System.getenv("INDEXING_DRIVE_URL") : "40.127.198.131" ;
//    public static int DOWNLOAD_SERVICE_PORT = (System.getenv("INDEXING_DOWNLOAD_SERVICE_PORT")!=null) ? Integer.parseInt(System.getenv("INDEXING_DOWNLOAD_SERVICE_PORT")) : 8082;
//    public static int FILE_SERVICE_PORT =  (System.getenv("INDEXING_FILE_SERVICE_PORT")!=null) ? Integer.parseInt(System.getenv("INDEXING_FILE_SERVICE_PORT")) : 8083;

    public static String FILE_SERVICE_URL =  (System.getenv("INDEXING_FILE_SERVICE_URL")!=null) ? System.getenv("INDEXING_FILE_SERVICE_URL") : "13.79.86.8:8083";
    public static String DOWNLOAD_SERVICE_URL =  (System.getenv("INDEXING_DOWNLOAD_SERVICE_URL")!=null) ? System.getenv("INDEXING_DOWNLOAD_SERVICE_URL") : "13.79.86.8:8082";
    public static int CHUNK_SIZE = (System.getenv("INDEXING_CHUNK_SIZE")!=null) ? Integer.parseInt(System.getenv("INDEXING_CHUNK_SIZE")) : 10000;
    public static int SUFF_PRE_SIZE = (System.getenv("INDEXING_SUFF_PRE_SIZE")!=null) ? Integer.parseInt(System.getenv("INDEXING_SUFF_PRE_SIZE")) : 100;
    public static int SUFF_PRE_COUNT_PER_DOCUMENT= CHUNK_SIZE / SUFF_PRE_SIZE;


}
