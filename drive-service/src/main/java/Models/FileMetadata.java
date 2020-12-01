package Models;

import DriveStubs.grpc.FileOuterClass;
import Services.DataFromDrive;
import com.github.javafaker.Faker;
import com.github.javafaker.File;
import com.google.protobuf.ProtocolStringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileMetadata {
    private String fileId;
    private String fileName;
    private String type;
    private long size;
    private User owner;
    private long createdAt;
    private long updatedAt;
    private Folder[] ancestors;

    public FileMetadata(String fileId, String fileName, String type, long size, User owner, long createdAt, long updatedAt, Folder[] ancestors){
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

    public void setAncestors(Folder[] ancestors) {
        this.ancestors = ancestors;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUpdatedAt(long updatedAt) {
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
        map.put("ancestors",ancestors);
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

    public static FileMetadata getMetadata (String fileId) {
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

    public static String getFileNameById(String fileId){
        FileOuterClass.File file = DataFromDrive.getFileById(fileId);
        return file.getName();
    }


}
