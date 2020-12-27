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
        map.put("metadata",metadata.getHashMap());

        ArrayList<HashMap<String,Object>> permissionList = new ArrayList<HashMap<String,Object>>();
        for (Permission permission: permissions) {
            permissionList.add(permission.getHashMap());
        }
        map.put("permissions",permissionList.toArray());
        map.put("content", content);
        return map;
    }

    public void elasticDo() throws Exception {
        String index = this.metadata.getOwner().getUserId();
        boolean error = false;
        String errorMessage = "";
        switch(elasticOperation){
            case UPDATE:
                if(metadata != null){
                    try{
                        ElasticService.updateMetadata(this.fileId,this.metadata,index);
                        LOGGER.info(String.format("Updated metadata of %s in elastic successfully"
                        , this.fileId));
                    }
                    catch(Exception e){
                        errorMessage = e.getMessage();
                        error = true;
                    }
                }

                if(permissions != null){
                    try{
                        ElasticService.updatePermissions(this.fileId,this.permissions,index);
                        LOGGER.info(String.format("Updated permissions of %s in elastic successfully"
                        , this.fileId));
                    }
                    catch(Exception e){
                        errorMessage = e.getMessage();
                        error = true;
                    }
                }
                break;
            case CREATE:
                try{
                    ElasticService.indexDocument(this,index);
                    LOGGER.info(String.format("Indexed document of %s in successfully"
                    , this.fileId));
                }
                catch(Exception e){
                    errorMessage = e.getMessage();
                    error = true;
                }
                break;
        }
        if(error){
            throw new Exception(errorMessage);
        }
    }

    public String toString(){
        String contentString = content.contains("@")? "keyBucket='"+content+"'": "ContentLength="+content.length();
        return String.format("Document{fileId='%s'\n" +
                        "metadata=%s\n" +
                        "permissions=%s\n" +
                        contentString +
                        "elasticOperation=%s}", fileId,metadata.toString(),
                Arrays.toString(permissions),contentString,elasticOperation);
    }
}
