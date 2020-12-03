package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.HashMap;

public class FileMetadata implements Serializable {
    private String fileId;
    private String fileName;
    private String type;
    private long size;
    private User owner;
    private long createdAt;
    private long updatedAt;
    private Folder[] ancestors;

    public FileMetadata(@JsonProperty("fileId") String fileId,
                        @JsonProperty("fileName") String fileName,
                        @JsonProperty("type") String type,
                        @JsonProperty("size") long size,
                        @JsonProperty("owner") User owner,
                        @JsonProperty("createdAt") long createdAt,
                        @JsonProperty("updatedAt") long updatedAt,
                        @JsonProperty("ancestors") Folder[] ancestors){
        this.fileId = fileId;
        this.fileName = fileName;
        this.type = type;
        this.size = size;
        this.owner = owner;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ancestors = ancestors;
    }

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

    public Folder[] getAncestors() {
        return ancestors;
    }

    public void setAncestors(@JsonProperty("ancestors") Folder[] ancestors) {
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
    public User getOwner(){
        return this.owner;
    }

    public HashMap<String,Object> getHashMap(){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("fileId",fileId);
        map.put("fileName",fileName);
        map.put("type",type);
        map.put("size",size);
        map.put("owner",owner.getHashMap());
        map.put("createdAt",createdAt);
        map.put("updatedAt",updatedAt);
        map.put("ancestors",Folder.getHashMapsArray(ancestors));
        return map;
    }

    public static Folder[] getRandomAncestors(){
        Faker faker = new Faker();
        Folder[] ancestors = new Folder[faker.random().nextInt(5)+1];
        for(int i = 0 ; i < ancestors.length ; i ++){
            Folder folder = Folder.getRandom();
        }
        return ancestors;
    }

    public static FileMetadata getRandom(String fileId , User owner , Folder[] ancestors){
        Faker faker = new Faker();
        String [] types = {"docx", "pptx", "pdf", "xlsx"};
        String type = types[faker.random().nextInt(types.length)];
        String fileName = faker.animal().name()+"."+type;
        long size = faker.random().nextLong();
        long createdAt = Math.abs(faker.random().nextLong());
        long updatedAt = createdAt + faker.random().nextLong();
        FileMetadata metadata = new FileMetadata(fileId,fileName, type, size, owner, createdAt, updatedAt,ancestors);
        return metadata;
    }
}
