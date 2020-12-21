package Services;

import Config.Config;
import Models.Document;
import Models.FileMetadata;
import Models.Permission;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import java.util.ArrayList;
import java.util.HashMap;

public class ElasticService {
    public static RestHighLevelClient client;
    static{
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(Config.ELASTIC_HOST, Config.ELASTIC_PORT, Config.ELASTIC_PROTOCOL)));

    }

    public static void delete(String fileId, String index) throws Exception {
        try {
            DeleteByQueryRequest request =
                    new DeleteByQueryRequest(index);
            request.setQuery(new MatchQueryBuilder("fileId", fileId));
            BulkByScrollResponse bulkResponse =
                    client.deleteByQuery(request, RequestOptions.DEFAULT);
            long deletedDocs = bulkResponse.getDeleted();

            System.out.println(deletedDocs);
        }
        catch(Exception e){
            throw e;
        }
    }

    public static void updateMetadata(String fileId, FileMetadata fileMetadata, String index) throws Exception {
        try {
            UpdateByQueryRequest request =
                    new UpdateByQueryRequest(index);
            request.setQuery(new MatchQueryBuilder("fileId", fileId));
            HashMap<String, Object> params = fileMetadata.getHashMap();
            request.setScript(
                    new Script(
                            ScriptType.INLINE, "painless",
                            "ctx._source.metadata = params.metadata",
                            params
                    )
            );
            BulkByScrollResponse bulkResponse =
                    client.updateByQuery(request, RequestOptions.DEFAULT);
        }
        catch(Exception e){
            throw e;
        }
    }

    public static void updatePermissions(String fileId, Permission[] permissions, String index) throws Exception {
        try {
            for (Permission element : permissions) {
                System.out.println(element.toString());
            }
            UpdateByQueryRequest request =
                    new UpdateByQueryRequest(index);
            request.setQuery(new MatchQueryBuilder("fileId", fileId));
            HashMap<String, Object> params = new HashMap<String, Object>();

            ArrayList<HashMap<String, Object>> permissionList = new ArrayList<HashMap<String, Object>>();
            for (Permission permission : permissions) {
                permissionList.add(permission.getHashMap());
            }
            params.put("permissions", permissionList.toArray());

            request.setScript(
                    new Script(
                            ScriptType.INLINE, "painless",
                            "ctx._source.permissions = params.permissions",
                            params
                    )
            );
            BulkByScrollResponse bulkResponse =
                    client.updateByQuery(request, RequestOptions.DEFAULT);
            System.out.println(bulkResponse.getUpdated());
        }
        catch(Exception e){
            throw e;
        }
    }

    public static void indexDocument(Document document, String index) throws Exception {
        try{
            IndexRequest request = new IndexRequest(index);
            HashMap<String,Object> map = document.getHashMap();
            request.source(map);
            client.index(request, RequestOptions.DEFAULT);
        }
        catch(Exception e){
            throw e;
        }
    }
}
