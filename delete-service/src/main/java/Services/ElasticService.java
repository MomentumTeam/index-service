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

public class ElasticService {

    private static final Logger LOGGER = LogManager.getLogger(ElasticService.class);

    public static RestHighLevelClient client;

    static{
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(Config.ELASTIC_HOST,
                        Config.ELASTIC_PORT, Config.ELASTIC_PROTOCOL)));

    }

    public static void delete(String fileId, String index) throws Exception {
        try {
            DeleteByQueryRequest request =
                    new DeleteByQueryRequest(index);
            request.setQuery(new MatchQueryBuilder(fileId,index));
            BulkByScrollResponse bulkResponse =
                    client.deleteByQuery(request, RequestOptions.DEFAULT);
            LOGGER.info(String.format("document '%s' deleted successfully from elastic", fileId));
        }
        catch(Exception e){
            throw e;
        }
    }
}
