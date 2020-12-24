package Services;

import com.google.common.io.ByteSource;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class ParsingService {

    public static String convertToUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }

    public static String getContent(byte [] fileArray) throws TikaException, SAXException, IOException {
        // return the file content using Tika
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler(-1);
        Metadata metadata = new Metadata();
        try{
            //File initialFile = new File(path);
//            byte [] fileContent = Files.readAllBytes(initialFile.toPath());
            System.out.println(fileArray);
            InputStream targetStream =new ByteArrayInputStream(fileArray);
//            InputStream targetStream = new FileInputStream(initialFile);
            parser.parse(targetStream, handler, metadata);
            System.out.println(handler.toString());
            return handler.toString();
        }
        catch(Exception e){
            throw e;
        }
    }

    public static String cleanContent(String content){
        String cleanContent = content.replaceAll("\\s+", " "); // Without spaces
        cleanContent = cleanContent.replaceAll("[^A-Za-z0-9-\\x{0590}-\\x{05FF}-\\x{0600}-\\x{06FF}-\n- ]",""); // Without special characters
//        cleanContent = cleanContent.replaceAll("[^\\w\\s]","");; // Without special characters
        return cleanContent;
    }

}
