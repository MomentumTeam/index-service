package Services;
import Config.Config;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;

import java.util.ArrayList;

public class ElasticService {

    private static final Logger LOGGER = LogManager.getLogger(ElasticService.class);

    public static HttpHost[] hostsArray;

    static{
        ArrayList<HttpHost> hostsList = new ArrayList<HttpHost>();
        for(String elasticHost : Config.ELASTIC_URLS){
            String protocol = elasticHost.substring(0,elasticHost.indexOf(":"));
            String host = elasticHost.substring(elasticHost.lastIndexOf("/")+1,elasticHost.lastIndexOf(":"));
            int port = Integer.parseInt(elasticHost.substring(elasticHost.lastIndexOf(":")+1));
            hostsList.add(new HttpHost(host,port,protocol));
        }
        hostsArray = hostsList.stream().toArray(HttpHost[]::new);
    }

    public static void delete(String fileId, String index) throws Exception {
        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(hostsArray));
            DeleteByQueryRequest request =
                    new DeleteByQueryRequest(index);
            request.setQuery(new MatchQueryBuilder("fileId",fileId));
            BulkByScrollResponse bulkResponse =
                    client.deleteByQuery(request, RequestOptions.DEFAULT);
            LOGGER.info(String.format("document '%s' deleted successfully from elastic", fileId));
        }
        catch(Exception e){
            throw e;
        }
    }
}
