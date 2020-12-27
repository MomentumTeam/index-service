package Services;

import Config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkService {

    public static String[][] getSuffixPrefixArrays(String content){
        try{
            String suffixPrefix;
            ArrayList<String[]> suffixPrefixArrays = new ArrayList<String[]>();
            ArrayList<String> suffixPrefixArray = new ArrayList<String>();
            int from,to,firstWhiteSpace;
            for (int i = Config.CHUNK_SIZE ; i < content.length() ; i += Config.CHUNK_SIZE){

                from = content.lastIndexOf(' ', i - Config.SUFF_PRE_SIZE) + 1;
                firstWhiteSpace = content.indexOf(' ', i + Config.SUFF_PRE_SIZE);
                to = firstWhiteSpace == -1 ? content.length() : firstWhiteSpace;

                suffixPrefix = content.substring(from , to);
                suffixPrefixArray.add(suffixPrefix);
                if(suffixPrefixArray.size() == Config.SUFF_PRE_COUNT_PER_DOCUMENT) {
                    suffixPrefixArrays.add(Arrays.stream(suffixPrefixArray.toArray()).toArray(String[]::new));
                    suffixPrefixArray = new ArrayList<String>();
                }
            }
            if(suffixPrefixArray.size() > 0){
                suffixPrefixArrays.add(Arrays.stream(suffixPrefixArray.toArray()).toArray(String[]::new));
            }
            return Arrays.stream(suffixPrefixArrays.toArray()).toArray(String[][]::new);
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
