package Models;


import Enums.ElasticOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Document implements Serializable {
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

    public static Document getRandom(FileMetadata metadata, Permission [] permissions){
        Faker faker = new Faker();
        String content = faker.rickAndMorty().quote();
        return new Document(metadata.getFileId(), metadata, permissions,content, ElasticOperation.CREATE);
    }
}
