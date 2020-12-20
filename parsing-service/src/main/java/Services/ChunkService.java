package Services;

import Config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkService {

    public static String[][] getSuffixPrefixArrays(String content){
        try{
            String preSuff;
            ArrayList<String[]> preSuffArrays = new ArrayList<String[]>();
            ArrayList<String> preSuffArray = new ArrayList<String>();
            int from,to,firstWhiteSpace;
            for (int i = Config.CHUNK_SIZE ; i < content.length() ; i += Config.CHUNK_SIZE){

                from = content.lastIndexOf(' ', i - Config.PRE_SUFF_SIZE) + 1;
                firstWhiteSpace = content.indexOf(' ', i + Config.PRE_SUFF_SIZE);
                to = firstWhiteSpace == -1 ? content.length() : firstWhiteSpace;

                preSuff = content.substring(from , to);
                preSuffArray.add(preSuff);
                if(preSuffArray.size() == Config.PRE_SUFF_PARTS_COUNT) {
                    preSuffArrays.add(Arrays.stream(preSuffArray.toArray()).toArray(String[]::new));
                    preSuffArray = new ArrayList<String>();
                }
            }
            if(preSuffArray.size() > 0){
                preSuffArrays.add(Arrays.stream(preSuffArray.toArray()).toArray(String[]::new));
            }
            return Arrays.stream(preSuffArrays.toArray()).toArray(String[][]::new);
        }
        catch(Exception exception){
            throw exception;
        }
    }

    public static String[] getSuffixPrefixStringArray(String content){
        return getSuffixPrefixStringArray(getSuffixPrefixArrays(content));
    }

    public static String[] getSuffixPrefixStringArray(String[][] suffixPrefixArrays){
        String[] suffixPrefixStringArray = new String[suffixPrefixArrays.length];
        for(int i = 0 ; i < suffixPrefixArrays.length ; i++){
            suffixPrefixStringArray[i] = String.join("#",suffixPrefixArrays[i]);
        }
        return suffixPrefixStringArray;
    }

    public static String [] getChunks(String content){
        List<String> chunks = new ArrayList<String>();
        String chunk;
        int from,to,firstWhiteSpace;

        for (int i = 0 ; i < content.length() ; i += Config.CHUNK_SIZE){
            from = content.lastIndexOf(' ', i) + 1;
            firstWhiteSpace = content.indexOf(' ', i + Config.CHUNK_SIZE);
            to = firstWhiteSpace == -1 ? content.length() : firstWhiteSpace;
            chunk = content.substring(from, to);
            chunks.add(chunk);
        }

        String [] arrayChunks = new String[chunks.size()];
        chunks.toArray(arrayChunks);
        return arrayChunks;
    }
}
