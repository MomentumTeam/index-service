package Config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Config {

    public static final int HC_PORT = (System.getenv("INDEXING_PARSING_SERVICE_HC_PORT")!=null)? Integer.parseInt(System.getenv("INDEXING_PARSING_SERVICE_HC_PORT")): 8082;
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

    public static String FILE_SERVICE_URL =  (System.getenv("INDEXING_FILE_SERVICE_URL")!=null) ? System.getenv("INDEXING_FILE_SERVICE_URL") : "13.70.205.201:8083";
    public static String DOWNLOAD_SERVICE_URL =  (System.getenv("INDEXING_DOWNLOAD_SERVICE_URL")!=null) ? System.getenv("INDEXING_DOWNLOAD_SERVICE_URL") : "13.70.205.201:8082";
    public static int CHUNK_SIZE = (System.getenv("INDEXING_CHUNK_SIZE")!=null) ? Integer.parseInt(System.getenv("INDEXING_CHUNK_SIZE")) : 10000;
    public static int SUFF_PRE_SIZE = (System.getenv("INDEXING_SUFF_PRE_SIZE")!=null) ? Integer.parseInt(System.getenv("INDEXING_SUFF_PRE_SIZE")) : 100;
    public static int SUFF_PRE_COUNT_PER_DOCUMENT= CHUNK_SIZE / SUFF_PRE_SIZE;

    public static String [] SUPPORTED_TYPES_ARRAY = new String[]{
            "text/html",
            "application/vnd.wap.xhtml+xml",
            "application/x-asp",
            "application/xhtml+xml",
            "application/vnd.ms-powerpoint.template.macroenabled.12",
            "application/vnd.ms-excel.addin.macroenabled.12",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.template",
            "application/vnd.ms-excel.sheet.binary.macroenabled.12",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "application/vnd.ms-powerpoint.slide.macroenabled.12",
            "application/vnd.ms-visio.drawing",
            "application/vnd.ms-powerpoint.slideshow.macroenabled.12",
            "application/vnd.ms-powerpoint.presentation.macroenabled.12",
            "application/vnd.openxmlformats-officedocument.presentationml.slide",
            "application/vnd.ms-excel.sheet.macroenabled.12",
            "application/vnd.ms-word.template.macroenabled.12",
            "application/vnd.ms-word.document.macroenabled.12",
            "application/vnd.ms-powerpoint.addin.macroenabled.12",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.template",
            "application/vnd.ms-xpsdocument",
            "application/vnd.ms-visio.drawing.macroenabled.12",
            "application/vnd.ms-visio.template.macroenabled.12",
            "model/vnd.dwfx+xps",
            "application/vnd.openxmlformats-officedocument.presentationml.template",
            "application/vnd.openxmlformats-officedocument.presentationml.presentation",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            "application/vnd.ms-visio.stencil",
            "application/vnd.ms-visio.template",
            "application/vnd.openxmlformats-officedocument.presentationml.slideshow",
            "application/vnd.ms-visio.stencil.macroenabled.12",
            "application/vnd.ms-excel.template.macroenabled.12",
            "application/vnd.ms-excel.workspace.3",
            "application/vnd.ms-excel.workspace.4",
            "application/vnd.ms-excel.sheet.2",
            "application/vnd.ms-excel.sheet.3",
            "application/vnd.ms-excel.sheet.4",
            "application/vnd.ms-wordml",
            "application/vnd.ms-word2006ml",
            "application/x-ms-owner",
            "application/x-vnd.oasis.opendocument.presentation",
            "application/vnd.oasis.opendocument.chart",
            "application/x-vnd.oasis.opendocument.text-web",
            "application/x-vnd.oasis.opendocument.image",
            "application/vnd.oasis.opendocument.graphics-template",
            "application/vnd.oasis.opendocument.text-web",
            "application/x-vnd.oasis.opendocument.spreadsheet-template",
            "application/vnd.oasis.opendocument.spreadsheet-template",
            "application/vnd.sun.xml.writer",
            "application/x-vnd.oasis.opendocument.graphics-template",
            "application/vnd.oasis.opendocument.graphics",
            "application/vnd.oasis.opendocument.spreadsheet",
            "application/x-vnd.oasis.opendocument.chart",
            "application/x-vnd.oasis.opendocument.spreadsheet",
            "application/x-vnd.oasis.opendocument.text",
            "application/x-vnd.oasis.opendocument.text-template",
            "application/vnd.oasis.opendocument.formula-template",
            "application/x-vnd.oasis.opendocument.formula",
            "application/x-vnd.oasis.opendocument.presentation-template",
            "application/vnd.oasis.opendocument.presentation-template",
            "application/vnd.oasis.opendocument.text",
            "application/vnd.oasis.opendocument.text-template",
            "application/x-vnd.oasis.opendocument.formula-template",
            "application/x-vnd.oasis.opendocument.text-master",
            "application/vnd.oasis.opendocument.presentation",
            "application/vnd.oasis.opendocument.text-master",
            "application/vnd.apple.keynote",
            "application/vnd.apple.iwork",
            "application/vnd.apple.numbers",
            "application/vnd.apple.pages",
            "application/vnd.wordperfect; version=5.1",
            "application/vnd.wordperfect; version=5.0",
            "application/vnd.wordperfect; version=6.x",
            "org.apache.tika.parser.xml.DcXMLParser",
            "application/xml",
            "application/x-quattro-pro; version=9",
            "application/pdf",
            "application/x-tika-msoffice-embedded; format=ole10_native",
            "application/msword",
            "application/vnd.visio",
            "application/vnd.ms-project",
            "application/x-tika-msworks-spreadsheet",
            "application/x-mspublisher",
            "application/vnd.ms-powerpoint",
            "application/x-tika-msoffice",
            "application/sldworks",
            "application/x-tika-ooxml-protected",
            "application/vnd.ms-excel",
            "application/vnd.ms-outlook",
            "text/javascript",
            "application/x-abiword",
            "text/css",
            "text/csv",
            "application/json",
            "application/x-httpd-php",
            "text/plain"
    };

    public static Set<String> SUPPORTED_TYPES = new HashSet<String>(Arrays.asList(SUPPORTED_TYPES_ARRAY));

}
