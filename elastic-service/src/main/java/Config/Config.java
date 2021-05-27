package Config;

import java.util.Arrays;

public class Config {

    public static final int HC_PORT = (System.getenv("INDEXING_ELASTIC_SERVICE_HC_PORT")!=null)? Integer.parseInt(System.getenv("INDEXING_ELASTIC_SERVICE_HC_PORT")): 8083;
    public static final int RABBIT_MAX_WAIT_TIME = (System.getenv("RABBIT_MAX_WAIT_TIME")!=null)? Integer.parseInt(System.getenv("RABBIT_MAX_WAIT_TIME")): 300000;
    public static final String RABBIT_URL = (System.getenv("INDEXING_RABBIT_URL")!=null) ? System.getenv("INDEXING_RABBIT_URL") : "amqp://13.70.205.201" ;
    public static final String EXCHANGE_NAME = (System.getenv("INDEXING_EXCHANGE_NAME")!=null) ? System.getenv("INDEXING_EXCHANGE_NAME") : "indexService" ;

    public static final String ELASTIC_SERVICE_QUEUE_NAME = (System.getenv("INDEXING_ELASTIC_SERVICE_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ELASTIC_SERVICE_QUEUE_NAME") : "elasticService" ;
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = (System.getenv("INDEXING_ELASTIC_SERVICE_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ELASTIC_SERVICE_ROUTING_KEY") : "elasticServiceKey" ;

    public static final String ERROR_QUEUE_NAME = (System.getenv("INDEXING_ERROR_QUEUE_NAME")!=null) ? System.getenv("INDEXING_ERROR_QUEUE_NAME") : "error" ;
    public static final String  ERROR_ROUTING_KEY = (System.getenv("INDEXING_ERROR_ROUTING_KEY")!=null) ? System.getenv("INDEXING_ERROR_ROUTING_KEY") : "errorKey";

    public static final String[] ELASTIC_URLS = (System.getenv("INDEXING_ELASTIC_URLS")!=null) ?
            Arrays.asList(System.getenv("INDEXING_ELASTIC_URLS").split(",")).stream().toArray(String[]::new)
    :  Arrays.asList("http://13.70.205.201:9200".split(",")).stream().toArray(String[]::new);

    public static final String EVENTS_QUEUE_NAME = (System.getenv("INDEXING_EVENTS_QUEUE_NAME")!=null) ? System.getenv("INDEXING_EVENTS_QUEUE_NAME") : "events";
    public static final String  EVENTS_ROUTING_KEY = (System.getenv("INDEXING_EVENTS_ROUTING_KEY")!=null) ? System.getenv("INDEXING_EVENTS_ROUTING_KEY") : "eventsKey";

    public static final String INDEX_MAPPING = "{\n" +
            "      \"properties\" : {\n" +
            "        \"ancestors\" : {\n" +
            "          \"type\" : \"text\",\n" +
            "          \"fields\" : {\n" +
            "            \"keyword\" : {\n" +
            "              \"type\" : \"keyword\",\n" +
            "              \"ignore_above\" : 256\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"content\" : {\n" +
            "          \"type\" : \"text\",\n" +
//            "          \"analyzer\":\"index_ngram_analyzer\",\n" +
//            "          \"search_analyzer\": \"search_term_analyzer\",\n" +
//            "          \"term_vector\":\"with_positions_offsets\"," +
            "          \"fields\" : {\n" +
            "            \"keyword\" : {\n" +
            "              \"type\" : \"keyword\",\n" +
            "              \"ignore_above\" : 256\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"createdAt\" : {\n" +
            "          \"type\" : \"long\"\n" +
            "        },\n" +
            "        \"fileId\" : {\n" +
            "          \"type\" : \"text\",\n" +
            "          \"fields\" : {\n" +
            "            \"keyword\" : {\n" +
            "              \"type\" : \"keyword\",\n" +
            "              \"ignore_above\" : 256\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"fileName\" : {\n" +
            "          \"type\" : \"text\",\n" +
            "          \"fields\" : {\n" +
            "            \"keyword\" : {\n" +
            "              \"type\" : \"keyword\",\n" +
            "              \"ignore_above\" : 256\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"owner\" : {\n" +
            "          \"properties\" : {\n" +
            "            \"hierarchy\" : {\n" +
            "              \"type\" : \"text\",\n" +
            "              \"fields\" : {\n" +
            "                \"keyword\" : {\n" +
            "                  \"type\" : \"keyword\",\n" +
            "                  \"ignore_above\" : 256\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"name\" : {\n" +
            "              \"type\" : \"text\",\n" +
            "              \"fields\" : {\n" +
            "                \"keyword\" : {\n" +
            "                  \"type\" : \"keyword\",\n" +
            "                  \"ignore_above\" : 256\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"userId\" : {\n" +
            "              \"type\" : \"text\",\n" +
            "              \"fields\" : {\n" +
            "                \"keyword\" : {\n" +
            "                  \"type\" : \"keyword\",\n" +
            "                  \"ignore_above\" : 256\n" +
            "                }\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"permissions\" : {\n" +
            "         \"type\" : \"nested\",\n"+
            "         \"include_in_parent\" : true,\n"+
            "          \"properties\" : {\n" +
            "            \"ancestorId\" : {\n" +
            "              \"type\" : \"text\",\n" +
            "              \"fields\" : {\n" +
            "                \"keyword\" : {\n" +
            "                  \"type\" : \"keyword\",\n" +
            "                  \"ignore_above\" : 256\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"role\" : {\n" +
            "              \"type\" : \"text\",\n" +
            "              \"fields\" : {\n" +
            "                \"keyword\" : {\n" +
            "                  \"type\" : \"keyword\",\n" +
            "                  \"ignore_above\" : 256\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"user\" : {\n" +
            "              \"properties\" : {\n" +
            "                \"hierarchy\" : {\n" +
            "                  \"type\" : \"text\",\n" +
            "                  \"fields\" : {\n" +
            "                    \"keyword\" : {\n" +
            "                      \"type\" : \"keyword\",\n" +
            "                      \"ignore_above\" : 256\n" +
            "                    }\n" +
            "                  }\n" +
            "                },\n" +
            "                \"name\" : {\n" +
            "                  \"type\" : \"text\",\n" +
            "                  \"fields\" : {\n" +
            "                    \"keyword\" : {\n" +
            "                      \"type\" : \"keyword\",\n" +
            "                      \"ignore_above\" : 256\n" +
            "                    }\n" +
            "                  }\n" +
            "                },\n" +
            "                \"userId\" : {\n" +
            "                  \"type\" : \"text\",\n" +
            "                  \"fields\" : {\n" +
            "                    \"keyword\" : {\n" +
            "                      \"type\" : \"keyword\",\n" +
            "                      \"ignore_above\" : 256\n" +
            "                    }\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"size\" : {\n" +
            "          \"type\" : \"long\"\n" +
            "        },\n" +
            "        \"type\" : {\n" +
            "          \"type\" : \"text\",\n" +
            "          \"fields\" : {\n" +
            "            \"keyword\" : {\n" +
            "              \"type\" : \"keyword\",\n" +
            "              \"ignore_above\" : 256\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"updatedAt\" : {\n" +
            "          \"type\" : \"long\"\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    public static final String INDEX_SETTINGS = "{\n" +
            "    \"index\":{\n" +
            "      \"max_ngram_diff\": 100,\n" +
            "      \"analysis\": {\n" +
            "        \"tokenizer\": {\n" +
            "          \"ngram_tokenizer\": {\n" +
            "            \"type\": \"ngram\",\n" +
            "            \"min_gram\": \"1\",\n" +
            "            \"max_gram\": \"15\",\n" +
            "            \"token_chars\": [ \"letter\", \"digit\" ]\n" +
            "          }\n" +
            "        },\n" +
            "      \"analyzer\": {\n" +
            "        \"index_ngram_analyzer\": {\n" +
            "          \"type\": \"custom\",\n" +
            "          \"tokenizer\": \"ngram_tokenizer\",\n" +
            "          \"filter\": [ \"lowercase\" ]\n" +
            "        },\n" +
            "        \"search_term_analyzer\": {\n" +
            "          \"type\": \"custom\",\n" +
            "          \"tokenizer\": \"keyword\",\n" +
            "          \"filter\": \"lowercase\" \n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "    }\n" +
            "  }";
}
