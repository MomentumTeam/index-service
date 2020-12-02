package Models;

import DriveStubs.grpc.FileOuterClass;
import Services.DataFromDrive;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import com.github.javafaker.File;
import com.google.protobuf.ProtocolStringList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static FileMetadata getMetadata (String fileId) {
        try{
            FileOuterClass.File file = DataFromDrive.getFileById(fileId);
            String fileName = file.getName();
            String type = file.getType();
            long size = file.getSize();
            User owner = User.getUser(file.getOwnerID());
            long createdAt = file.getCreatedAt();
            long updatedAt = file.getUpdatedAt();
            ProtocolStringList ancestors = DataFromDrive.getAncestors(fileId).getAncestorsList();
            ArrayList <Folder> ancestorsArray = new ArrayList<Folder>();
            for (String ancestor : ancestors)
            {
                ancestorsArray.add(Folder.getFolder(ancestor));
            }
            Folder[] ancestorsFolderArray = Arrays.stream(ancestorsArray.toArray()).toArray(Folder[]::new);
            FileMetadata metadata = new FileMetadata(fileId,fileName, type, size, owner, createdAt, updatedAt,ancestorsFolderArray);
            return metadata;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static String getFileNameById(String fileId){
        try{
            FileOuterClass.File file = DataFromDrive.getFileById(fileId);
            return file.getName();
        }
        catch(Exception e){
            throw e;
        }
    }
}
