package Services;

import Config.Config;
import Models.Document;
import Models.FileMetadata;
import Models.Permission;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ElasticService {
    public static HttpHost[] hostsArray;
    static{
        ArrayList <HttpHost> hostsList = new ArrayList<HttpHost>();
        for(String elasticHost : Config.ELASTIC_URLS){
            String protocol = elasticHost.substring(0,elasticHost.indexOf(":"));
            String host = elasticHost.substring(elasticHost.lastIndexOf("/")+1,elasticHost.lastIndexOf(":"));
            int port = Integer.parseInt(elasticHost.substring(elasticHost.lastIndexOf(":")+1));
            hostsList.add(new HttpHost(host,port,protocol));
        }
        hostsArray = hostsList.stream().toArray(HttpHost[]::new);
    }

    public static void updateMetadata(String fileId, FileMetadata fileMetadata, String[] indices) throws Exception {
        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(hostsArray));
            UpdateByQueryRequest request =
                    new UpdateByQueryRequest(indices);
            request.setQuery(new MatchQueryBuilder("fileId", fileId));
            request.setIndicesOptions(IndicesOptions.fromOptions(true,
                    false,
                    false,
                    false));
            HashMap<String, Object> params = fileMetadata.getHashMap();
            request.setScript(
                    new Script(
                            ScriptType.INLINE, "painless",
                            "for (k in params.keySet()){if (!k.equals('ctx')){ctx._source.put(k, params.get(k))}}"
                            ,
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

    public static void delete(String fileId, String dataTime, String index) throws Exception {
        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(hostsArray));
            DeleteByQueryRequest request =
                    new DeleteByQueryRequest(index);
            BoolQueryBuilder boolQuery = new BoolQueryBuilder();
            boolQuery.must(new MatchQueryBuilder("fileId",fileId));
            boolQuery.must(new MatchQueryBuilder("dataTime",dataTime));
            request.setQuery(boolQuery);
            BulkByScrollResponse bulkResponse =
                    client.deleteByQuery(request, RequestOptions.DEFAULT);
        }
        catch(Exception e){
            throw e;
        }
    }

    public static void DeleteIfAlreadyExists(Document document, String index) throws Exception {
        try{
            Map<String,Object> firstHit = getFirstHit(document.getFileId(), new String[]{index});
            String dataTimeFromElastic = (String)(firstHit.get("dataTime"));
            String dataTime = document.getDataTime();
            if(!dataTimeFromElastic.equals(dataTime)){
                ElasticService.delete(document.getFileId(), dataTimeFromElastic, index);
            }
        }
        catch(Exception e){
            return;
        }

    }

    public static Map <String,Object> getFirstHit(String fileId, String[] indices) throws Exception {
        try{
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(hostsArray));
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("fileId", fileId);
            SearchRequest searchRequest = new SearchRequest(indices);
            searchRequest.indicesOptions(IndicesOptions.fromOptions(true,
                    false,
                    false,
                    false));
            searchRequest.source(sourceBuilder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            SearchHit[] searchHits = hits.getHits();
            if(searchHits.length == 0){
                throw new Exception(String.format("Did not find document of " +
                        "fileId='%s'", fileId));
            }
            SearchHit first = searchHits[0];
            Map<String,Object> firstHitMap = first.getSourceAsMap();
            return firstHitMap;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static void updatePermissions(String fileId, Permission[] permissions, String[] indices) throws Exception {
        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(hostsArray));
            ArrayList<HashMap<String, Object>> permissionList = new ArrayList<HashMap<String, Object>>();
            for (Permission permission : permissions) {
                permissionList.add(permission.getHashMap());
            }
            String ancestorId = permissions[0].getAncestorId();

            Map<String,Object> firstHit = getFirstHit(fileId,indices);

            if (firstHit.containsKey("permissions") && firstHit.get("permissions") != null){

                for(Map<String,Object> permissionMap : (Collection<Map<String,Object>>) firstHit.get("permissions")){
                    Permission curPermission = new Permission(permissionMap);
                    if(!curPermission.getAncestorId().equals(ancestorId)){
                        permissionList.add(curPermission.getHashMap());
                    }
                }
            }

            UpdateByQueryRequest request =
                    new UpdateByQueryRequest(indices);
            request.setQuery(new MatchQueryBuilder("fileId", fileId));
            request.setIndicesOptions(IndicesOptions.fromOptions(true,
                    false,
                    false,
                    false));
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("permissions", permissionList.toArray());

            request.setScript(
                    new Script(
                            ScriptType.INLINE, "painless",
                            "ctx._source.permissions=params.permissions",
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

    public static void indexDocument(Document document, String index) throws Exception {
        try{
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(hostsArray));
            GetIndexRequest getIndexRequest = new GetIndexRequest(index);
            // Check if the index already exists
            boolean indexExists = client.indices().exists(getIndexRequest,RequestOptions.DEFAULT);

            // Create the index
            if(!indexExists){
                CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
                createIndexRequest.mapping(Config.INDEX_MAPPING, XContentType.JSON);
                client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            }

            // Index the document
            IndexRequest indexRequest = new IndexRequest(index);
            HashMap<String,Object> map = document.getHashMap();
            indexRequest.source(map);
            client.index(indexRequest, RequestOptions.DEFAULT);
        }
        catch(Exception e){
            throw e;
        }
    }

}
