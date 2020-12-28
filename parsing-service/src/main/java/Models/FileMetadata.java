package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Arrays;

public class FileMetadata implements Serializable {
    private String fileId;
    private String fileName;
    private String type;
    private long size;
    private User owner;
    private long createdAt;
    private long updatedAt;
    private String[] ancestors;
    private String key;
    private String bucket;

    public FileMetadata(@JsonProperty("fileId") String fileId,
                        @JsonProperty("fileName") String fileName,
                        @JsonProperty("type") String type,
                        @JsonProperty("size") long size,
                        @JsonProperty("owner") User owner,
                        @JsonProperty("createdAt") long createdAt,
                        @JsonProperty("updatedAt") long updatedAt,
                        @JsonProperty("ancestors") String[] ancestors,
                        @JsonProperty("key") String key,
                        @JsonProperty("bucket") String bucket){
        this.fileId = fileId;
        this.fileName = fileName;
        this.type = type;
        this.size = size;
        this.owner = owner;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ancestors = ancestors;
        this.key = key;
        this.bucket = bucket;
    }

    public String getBucket() { return bucket; }

    public String getKey() { return key; }

    public String getFileId() {
        return fileId;
    }

    public long getSize() {
        return size;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getFileName() {
        return fileName;
    }

    public String getType() {
        return type;
    }

    public String[] getAncestors() {
        return ancestors;
    }

    public User getOwner(){
        return this.owner;
    }

    public void setBucket(@JsonProperty("bucket") String bucket) { this.bucket = bucket; }

    public void setKey(@JsonProperty("key") String key) { this.key = key; }

    public void setAncestors(@JsonProperty("ancestors") String[] ancestors) {
        this.ancestors = ancestors;
    }

    public void setCreatedAt(@JsonProperty("createdAt") long createdAt) {
        this.createdAt = createdAt;
    }

    public void setFileId(@JsonProperty("fileId") String fileId) {
        this.fileId = fileId;
    }

    public void setFileName(@JsonProperty("fileName") String fileName) {
        this.fileName = fileName;
    }

    public void setOwner(@JsonProperty("owner") User owner) {
        this.owner = owner;
    }

    public void setSize(@JsonProperty("size") long size) {
        this.size = size;
    }

    public void setType(@JsonProperty("type") String type) {
        this.type = type;
    }

    public void setUpdatedAt(@JsonProperty("updatedAt") long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString(){
        String ancestorsString = ancestors==null?"NULL":Arrays.toString(ancestors);
        String ownerString = owner==null?"NULL":owner.toString();
        return String.format("Metadata{fileId='%s', filename='%s', type='%s'" +
                        ", size='%s', owner='%s', createdAt='%s', updatedAt='%s', ancestors='%s'" +
                        ", key='%s', bucket='%s'",
                fileId ,fileName, type, size, ownerString, createdAt, updatedAt, ancestorsString, key, bucket);
    }
}
