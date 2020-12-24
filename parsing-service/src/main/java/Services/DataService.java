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


    public static byte[] download(String key, String bucket) throws IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(Config.DRIVE_URL, Config.DOWNLOAD_SERVICE_PORT).usePlaintext().build();
        DownloadGrpc.DownloadBlockingStub downloadStub = DownloadGrpc.newBlockingStub(channel);
        DownloadService.DownloadRequest downloadRequest = DownloadService.DownloadRequest.newBuilder()
                .setBucket(bucket).setKey(key).build();
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
        byte[] result = new byte[byteList.size()];
        for(int i = 0; i < byteList.size(); i++) {
            result[i] = byteList.get(i).byteValue();
        }
        return result;
//        String path = downloadFolder + "/"+fileId;
//        try (FileOutputStream fos = new FileOutputStream(path)) {
//            fos.write(Bytes.toArray(byteList));
//            return path;
//            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
//        } catch (IOException e) {
//            throw e;
//        }
    }
}
