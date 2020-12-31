package Config;

public class Config {

    public static final String RABBIT_URL = "localhost";
    public static final String EXCHANGE_NAME = "indexService";

    public static final String ELASTIC_SERVICE_QUEUE_NAME = "elasticService";
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = "elasticServiceKey";

    public static final String ERROR_QUEUE_NAME = "error";
    public static final String  ERROR_ROUTING_KEY = "errorKey";

    public static final String ELASTIC_HOST = "137.135.166.218";
    public static final int ELASTIC_PORT = 9200;
    public static final String ELASTIC_PROTOCOL = "http";

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

}
