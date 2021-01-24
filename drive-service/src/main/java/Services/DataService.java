package Services;

import Config.Config;
import DriveStubs.grpc.*;
import Enums.DriveField;
import Models.FileMetadata;
import com.google.common.primitives.Bytes;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.commons.lang3.ArrayUtils;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataService {
    private static final ManagedChannel fileChannel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.FILE_SERVICE_PORT).usePlaintext().build();
    private static final ManagedChannel permissionChannel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.PERMISSION_SERVICE_PORT).usePlaintext().build();
    private static final ManagedChannel userChannel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.USER_SERVICE_PORT).usePlaintext().build();


    public static FileOuterClass.File getFileById(String fileId){
        try{
            FileServiceGrpc.FileServiceBlockingStub fileStub = FileServiceGrpc.newBlockingStub(fileChannel);
            FileOuterClass.GetByFileByIDRequest fileByIDRequest = FileOuterClass.GetByFileByIDRequest.newBuilder()
                    .setId(fileId).build();
            FileOuterClass.File file = fileStub.getFileByID(fileByIDRequest);
            return file;
        }
        catch(Exception e){
            throw e;
        }
    }

//    public static String download(String fileId, String downloadFolder) throws IOException {
//        FileOuterClass.File file = getFileById(fileId);
//        ManagedChannel channel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.DOWNLOAD_SERVICE_PORT).usePlaintext().build();
//        DownloadGrpc.DownloadBlockingStub downloadStub = DownloadGrpc.newBlockingStub(channel);
//        DownloadService.DownloadRequest downloadRequest = DownloadService.DownloadRequest.newBuilder()
//                .setBucket(file.getBucket()).setKey(file.getKey()).build();
//        Iterator<DownloadService.DownloadResponse> response = downloadStub.download(downloadRequest);
//        DownloadService.DownloadResponse dr;
//        ArrayList<Byte> byteList = new ArrayList<Byte>();
//        byte[] chunk;
//        for (Iterator<DownloadService.DownloadResponse> it = response; it.hasNext(); ) {
//            dr = it.next();
//            chunk = dr.getFile().toByteArray();
//            for(byte b: chunk) {
//                byteList.add(b);
//            }
//        }
//        String path = downloadFolder + "/"+fileId;
//        try (FileOutputStream fos = new FileOutputStream(path)) {
//            fos.write(Bytes.toArray(byteList));
//            return path;
//        } catch (IOException e) {
//            throw e;
//        }
//    }
    public static PermissionOuterClass.GetFilePermissionsResponse getPermissions(String fileId){
        try {
            PermissionGrpc.PermissionBlockingStub permissionStub = PermissionGrpc.newBlockingStub(permissionChannel);
            PermissionOuterClass.GetFilePermissionsRequest filePermissionsRequest = PermissionOuterClass.GetFilePermissionsRequest.newBuilder()
                    .setFileID(fileId).build();
            PermissionOuterClass.GetFilePermissionsResponse permissions = permissionStub.getFilePermissions(filePermissionsRequest);
            return permissions;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static UsersOuterClass.User getUser (String userId) {
        try{
            UsersGrpc.UsersBlockingStub userStub = UsersGrpc.newBlockingStub(userChannel);
            UsersOuterClass.GetByIDRequest userByIDRequest = UsersOuterClass.GetByIDRequest.newBuilder()
                    .setId(userId).build();
            UsersOuterClass.GetUserResponse user = userStub.getUserByID(userByIDRequest);
            return user.getUser();
        }
        catch(Exception e){
            throw e;
        }
    }

    public static FileOuterClass.GetAncestorsResponse getAncestors (String fileId) {
        try{
            FileServiceGrpc.FileServiceBlockingStub fileStub = FileServiceGrpc.newBlockingStub(fileChannel);
            FileOuterClass.GetAncestorsRequest ancestorsRequest = FileOuterClass.GetAncestorsRequest.newBuilder()
                    .setId(fileId).build();
            FileOuterClass.GetAncestorsResponse ancestors = fileStub.getAncestors(ancestorsRequest);
            return ancestors;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static String [] getDescendants (String fileId) {
        try{
            FileServiceGrpc.FileServiceBlockingStub fileStub = FileServiceGrpc.newBlockingStub(fileChannel);
            FileOuterClass.GetDescendantsByIDRequest descendantsRequest = FileOuterClass.GetDescendantsByIDRequest.newBuilder()
                    .setId(fileId).build();
            FileOuterClass.GetDescendantsByIDResponse descendants = fileStub.getDescendantsByID(descendantsRequest);
            String [] descendantsId = new String[descendants.getDescendantsCount()];
            for (int i = 0;i<descendants.getDescendantsCount();i++){
                descendantsId[i]= descendants.getDescendants(i).getFile().getId();
            }
            return descendantsId;
        }
        catch(Exception e){
            throw e;
        }
    }
}
