package Models;


import Enums.ElasticOperation;
import Services.ElasticService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Document implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(Document.class.getName());
    private ElasticOperation elasticOperation;
    private String fileId;
    private FileMetadata metadata;
    private Permission[] permissions;
    private String content;
    private String dataTime;

    public Document(@JsonProperty("fileId") String fileId,
                    @JsonProperty("metadata") FileMetadata metadata,
                    @JsonProperty("permissions") Permission[] permissions,
                    @JsonProperty("content") String content,
                    @JsonProperty("elasticOperation") ElasticOperation elasticOperation){
        this.fileId = fileId;
        this.metadata = metadata;
        this.permissions = permissions;
        this.content = content;
        this.elasticOperation = elasticOperation;
    }

    public void setDataTime(@JsonProperty("dataTime") String dataTime) { this.dataTime = dataTime; }

    public void setFileId(@JsonProperty("fileId") String fileId) {
        this.fileId = fileId;
    }

    public void setElasticOperation(ElasticOperation elasticOperation) {
        this.elasticOperation = elasticOperation;
    }

    public void setContent(@JsonProperty("content") String content) {
        this.content = content;
    }

    public void setMetadata(@JsonProperty("metadata") FileMetadata metadata) {
        this.metadata = metadata;
    }

    public void setPermissions(@JsonProperty("permissions") Permission[] permissions) {
        this.permissions = permissions;
    }

    public String getDataTime() { return dataTime; }

    public ElasticOperation getElasticOperation() {
        return elasticOperation;
    }

    public String getFileId() {
        return fileId;
    }

    public FileMetadata getMetadata() {
        return metadata;
    }

    public String getContent() {
        return content;
    }

    public Permission[] getPermissions() {
        return permissions;
    }

    public HashMap<String,Object> getHashMap(){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("fileId",fileId);
        map.putAll(metadata.getHashMap());
        ArrayList<HashMap<String,Object>> permissionList = new ArrayList<HashMap<String,Object>>();
        for (Permission permission: permissions) {
            permissionList.add(permission.getHashMap());
        }
        map.put("permissions",permissionList.toArray());
        map.put("content", content);
        map.put("dataTime", dataTime);
        return map;
    }

    public void elasticDo() throws Exception {
        String[] indices;
        boolean error = false;
        String errorMessage = "";
        switch(elasticOperation){
            case METADATA_UPDATE:
                if(metadata != null){
                    try{
                        indices = new String[]{this.metadata.getOwner().getUserId()};
                        if(ElasticService.existsInElastic(this.fileId, indices)){
                            LOGGER.info(String.format("Exists in elastic!"));
                            ElasticService.updateMetadata(this.fileId,this.metadata,indices);
                            LOGGER.info(String.format("Updated metadata of %s in elastic successfully"
                                    , this.fileId));
                        }
                        else{
                            LOGGER.info(String.format("fileId %s does not exist in elastic, however, operation " +
                                            "METADATA_UPDATE was received"
                                    , this.fileId));
                            throw new Exception("ELASTIC_FILE_ID_NOT_FOUND");
                        }
                    }
                    catch(Exception e){
                        if(e.getMessage().indexOf("ELASTIC_FILE_ID_NOT_FOUND") != -1) {
                            throw e;
                        }
                        errorMessage = e.getMessage();
                        error = true;
                    }
                }
                break;
            case CREATE:
                try{
                    String index  = this.metadata.getOwner().getUserId();
                    ElasticService.deleteIfAlreadyExists(this,index);
                    ElasticService.indexDocument(this,index);
                    LOGGER.info(String.format("Indexed document of %s in successfully"
                    , this.fileId));
                }
                catch(Exception e){
                    errorMessage = e.getMessage();
                    error = true;
                }
                break;
            case PERMISSIONS_UPDATE:
                try{
                    indices = Permission.indicesByPermissions(permissions);
                    if(ElasticService.existsInElastic(this.fileId, indices)) {
                        ElasticService.updatePermissions(this.fileId, this.permissions, indices);
                        LOGGER.info(String.format("Updated permissions of %s in elastic successfully"
                                , this.fileId));
                    }
                    else{
                        LOGGER.info(String.format("fileId %s does not exist in elastic, however, operation " +
                                        "PERMISSION_UPDATE was received"
                                , this.fileId));
                        throw new Exception("ELASTIC_FILE_ID_NOT_FOUND");
                    }
                }
                catch(Exception e){
                    if(e.getMessage().indexOf("ELASTIC_FILE_ID_NOT_FOUND") != -1) {
                        throw e;
                    }
                    errorMessage = e.getMessage();
                    error = true;
                }
        }
        if(error){
            throw new Exception(errorMessage);
        }
    }

    @Override
    public String toString(){
        String contentString = content==null?"content=NULL":
                (content.contains("@")? "keyBucket='"+content+"'": "ContentLength="+content.length());
        String fileIdString = fileId==null?"NULL":fileId;
        String metadataString = metadata==null?"NULL":metadata.toString();
        String permissionsString = permissions==null?"NULL":Arrays.toString(permissions);
        String elasticOperationString = elasticOperation==null?"NULL":elasticOperation.toString();

        return String.format("Document{fileId='%s',\n" +
                        "metadata=%s,\n" +
                        "permissions=%s,\n" +
                        contentString + ",\n" +
                        "elasticOperation=%s}", fileIdString,metadataString,
                permissionsString,elasticOperationString);
    }
}
