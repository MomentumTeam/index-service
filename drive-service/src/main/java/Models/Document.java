package Models;

import java.util.ArrayList;
import java.util.HashMap;

public class Document {
    private String fileId;
    private FileMetadata metadata;
    private Permission[] permissions;

    public Document(String fileId, FileMetadata metadata, Permission[] permissions){
        this.fileId = fileId;
        this.metadata = metadata;
        this.permissions = permissions;
    }

    public Document(Document document){
        this.fileId = document.fileId;
        this.metadata = document.metadata;
        this.permissions = document.permissions;
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
        return map;
    }

    public static Document getRandom(FileMetadata metadata, Permission [] permissions){
        return new Document(metadata.getFileId(), metadata, permissions);
    }

//    public static void indexRandomDocuments(int fileIdCount, int chunksCountPerFileId) throws Exception {
//        try {
//            Faker faker = new Faker();
//            for (int i = 0; i < fileIdCount; i++) {
//                User owner = User.getRandom();
//                String fileId = faker.idNumber().valid();
//                Folder[] ancestors = FileMetadata.getRandomAncestors();
//                FileMetadata metadata = FileMetadata.getRandom(fileId,owner,ancestors);
//                Permission [] permissions = Permission.getRandomArray();
//                for (int j = 0; j < chunksCountPerFileId; j++) {
//                    Document document = ChunkDocument.getRandom(metadata, permissions);
//                    ElasticService.indexDocument(document, "test");
//                }
//            }
//        }
//        catch(Exception e){
//            throw e;
//        }
//    }
}
