package Services;
import Config.Config;
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.IOException;

public class ElasticSearch {

    public static RestHighLevelClient client;

    static{
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

    }

    public static void delete(String fileId, String index) throws Exception {
        try {
            DeleteByQueryRequest request =
                    new DeleteByQueryRequest(index);
            request.setQuery(new MatchQueryBuilder(fileId,Config.index));
            BulkByScrollResponse bulkResponse =
                    client.deleteByQuery(request, RequestOptions.DEFAULT);
            long deletedDocs = bulkResponse.getDeleted();

            System.out.println(deletedDocs);
        }
        catch(Exception e){
            throw e;
        }

    }
}
