package Models;


import Enums.ElasticOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Document implements Serializable {
    private ElasticOperation elasticOperation;
    private String fileId;
    private FileMetadata metadata;
    private Permission[] permissions;
    private String content;

    public Document(@JsonProperty("fileId") String fileId ,
                    @JsonProperty("elasticOperation") ElasticOperation elasticOperation){
        this.fileId = fileId;
        this.elasticOperation = elasticOperation;
    }

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

    public String getFileId() {
        return fileId;
    }

    public FileMetadata getMetadata() {
        return metadata;
    }

    public String getContent() {
        return content;
    }

    public ElasticOperation getElasticOperation() {
        return elasticOperation;
    }

    public Permission[] getPermissions() {
        return permissions;
    }


    public static Document getRandom(FileMetadata metadata, Permission [] permissions){
        Faker faker = new Faker();
        String content = faker.rickAndMorty().quote();
        return new Document(metadata.getFileId(), metadata, permissions,content, ElasticOperation.CREATE);
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
