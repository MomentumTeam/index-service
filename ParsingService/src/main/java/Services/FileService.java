package Services;

import java.io.File;

public class FileService {

    public static void deleteFile(String path){
        File file = new File(path);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file or file already deleted.");
        }
    }
}
