//package RabbitModels;
//
//import Enums.DriveField;
//import Models.FileMetadata;
//import Models.Permission;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import java.io.Serializable;
//
//public class TikaRequest implements Serializable {
//    public String fileId;
//    public Permission [] permissions;
//    public FileMetadata metadata;
//    public String filePath;
//
//    public TikaRequest(@JsonProperty("fileId") final String fileId ,
//                        @JsonProperty("Permissions")final Permission [] permissions,
//                       @JsonProperty("Metadata")final FileMetadata metadata,
//                       @JsonProperty("filePath")final String filePath){
//        this.fileId = fileId;
//        this.permissions = permissions;
//        this.metadata = metadata;
//        this.filePath = filePath;
//    }
//}
