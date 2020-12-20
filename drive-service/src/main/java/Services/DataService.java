package Services;

import Config.Config;
import DriveStubs.grpc.*;
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
    public static FileOuterClass.File getFileById(String fileId){
        try{
            ManagedChannel channel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.FILE_SERVICE_PORT).usePlaintext().build();
            FileServiceGrpc.FileServiceBlockingStub fileStub = FileServiceGrpc.newBlockingStub(channel);
            FileOuterClass.GetByFileByIDRequest fileByIDRequest = FileOuterClass.GetByFileByIDRequest.newBuilder()
                    .setId(fileId).build();
            FileOuterClass.File file = fileStub.getFileByID(fileByIDRequest);
            return file;
        }
        catch(Exception e){
            throw e;
        }
    }

//    public ByteArrayOutputStream downloadFile(String fileName) {
//
//        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        final CountDownLatch finishLatch = new CountDownLatch(1);
//        final AtomicBoolean completed = new AtomicBoolean(false);
//
//        StreamObserver<DataChunk> streamObserver = new StreamObserver<DataChunk>() {
//            @Override
//            public void onNext(DataChunk dataChunk) {
//                try {
//                    baos.write(dataChunk.getData().toByteArray());
//                } catch (IOException e) {
//                    log.error("error on write to byte array stream", e);
//                    onError(e);
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                log.error("downloadFile() error", t);
//                finishLatch.countDown();
//            }
//
//            @Override
//            public void onCompleted() {
//                log.info("downloadFile() has been completed!");
//                completed.compareAndSet(false, true);
//                finishLatch.countDown();
//            }
//        };
//
//        try {
//
//            DownloadFileRequest.Builder builder = DownloadFileRequest
//                    .newBuilder()
//                    .setFileName(fileName);
//
//            nonBlockingStub.downloadFile(builder.build(), streamObserver);
//
//            finishLatch.await(5, TimeUnit.MINUTES);
//
//            if (!completed.get()) {
//                throw new Exception("The downloadFile() method did not complete");
//            }
//
//        } catch (Exception e) {
//            log.error("The downloadFile() method did not complete");
//        }
//
//        return baos;
//    }


    public static String download(String fileId, String downloadFolder) throws IOException {
        FileOuterClass.File file = getFileById(fileId);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.DOWNLOAD_SERVICE_PORT).usePlaintext().build();
        DownloadGrpc.DownloadBlockingStub downloadStub = DownloadGrpc.newBlockingStub(channel);
        DownloadService.DownloadRequest downloadRequest = DownloadService.DownloadRequest.newBuilder()
                .setBucket(file.getBucket()).setKey(file.getKey()).build();
        Iterator<DownloadService.DownloadResponse> response = downloadStub.download(downloadRequest);
        DownloadService.DownloadResponse dr;
        ArrayList<Byte> byteList = new ArrayList<Byte>();
        byte[] chunk;
        for (Iterator<DownloadService.DownloadResponse> it = response; it.hasNext(); ) {
            dr = it.next();
            chunk = dr.getFile().toByteArray();
            for(byte b: chunk) {
                byteList.add(b);
            }
        }

        String path = downloadFolder + "/"+fileId;
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(Bytes.toArray(byteList));
            return path;
            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
        } catch (IOException e) {
            throw e;
        }
    }
    public static PermissionOuterClass.GetFilePermissionsResponse getPermissions(String fileId){
        try {
            ManagedChannel channel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.PERMISSION_SERVICE_PORT).usePlaintext().build();
            PermissionGrpc.PermissionBlockingStub permissionStub = PermissionGrpc.newBlockingStub(channel);
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
            ManagedChannel channel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.USER_SERVICE_PORT).usePlaintext().build();
            UsersGrpc.UsersBlockingStub userStub = UsersGrpc.newBlockingStub(channel);
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
            ManagedChannel channel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.FILE_SERVICE_PORT).usePlaintext().build();
            FileServiceGrpc.FileServiceBlockingStub fileStub = FileServiceGrpc.newBlockingStub(channel);
            FileOuterClass.GetAncestorsRequest ancestorsRequest = FileOuterClass.GetAncestorsRequest.newBuilder()
                    .setId(fileId).build();
            FileOuterClass.GetAncestorsResponse ancestors = fileStub.getAncestors(ancestorsRequest);
            return ancestors;
        }
        catch(Exception e){
            throw e;
        }

    }
}
