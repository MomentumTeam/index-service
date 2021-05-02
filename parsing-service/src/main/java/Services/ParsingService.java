package Services;

import Rabbit.Producer;
import com.google.common.io.ByteSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class ParsingService {
    private static final Logger LOGGER = LogManager.getLogger(ParsingService.class);
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
            InputStream targetStream =new ByteArrayInputStream(fileArray);
            parser.parse(targetStream, handler, metadata);
            return handler.toString();
        }
        catch(Exception e){
            throw e;
        }
    }

    public static String cleanContent(String content){
        String cleanContent = content.replaceAll("[$&+,:;=?@#|'<>.^*()%!{}-]"," ");
        cleanContent = cleanContent.replaceAll("[^A-Za-z0-9\\x{0590}-\\x{05FF}\\x{0600}-\\x{06FF}\n ]",""); // Without special characters
        cleanContent = cleanContent.replaceAll("\\s+", " "); // Without spaces
        cleanContent = cleanContent.toLowerCase();
        return cleanContent;
    }

}
