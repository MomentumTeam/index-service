package Config;

public class Config {

    public static final String RABBIT_URL = System.getenv("RABBIT_URL");
    public static final String EXCHANGE_NAME = System.getenv("EXCHANGE_NAME");

    public static final String ELASTIC_SERVICE_QUEUE_NAME = System.getenv("ELASTIC_SERVICE_QUEUE_NAME");
    public static final String  ELASTIC_SERVICE_ROUTING_KEY = System.getenv("ELASTIC_SERVICE_ROUTING_KEY");

    public static final String ERROR_QUEUE_NAME = System.getenv("ERROR_QUEUE_NAME");
    public static final String  ERROR_ROUTING_KEY = System.getenv("ERROR_ROUTING_KEY");

    public static final String ELASTIC_HOST = System.getenv("ELASTIC_HOST");
    public static final int ELASTIC_PORT = Integer.parseInt(System.getenv("ELASTIC_PORT"));
    public static final String ELASTIC_PROTOCOL = System.getenv("ELASTIC_PROTOCOL");

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
