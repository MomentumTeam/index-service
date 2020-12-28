package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Folder implements Serializable {

    private String id;

    public Folder(@JsonProperty("id") String id){
        this.id = id;
    }

    public static Folder getFolder(String folderId){
        return new Folder(folderId);
    }

    public String getId(){
        return this.id;
    }

    public void setId(){
        this.id = id;
    }

    public HashMap<String,String> getHashMap(){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id",id);
        return map;
    }

    @Override
    public String toString(){
        return String.format("Folder{id='%s'}",id);
    }
}
