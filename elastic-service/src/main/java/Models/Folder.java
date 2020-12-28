package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.HashMap;

public class Folder implements Serializable {

    private String id;

    public Folder(@JsonProperty("id") String id){
        this.id = id;
    }

    public static HashMap<String,String>[] getHashMapsArray(Folder[] folders){
        HashMap<String,String>[] maps = new HashMap[folders.length];
        for(int i = 0 ; i < folders.length ; i ++){
            maps[i] = folders[i].getHashMap();
        }
        return maps;
    }

    public HashMap<String,String> getHashMap(){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id",this.id);
        return map;
    }

    @Override
    public String toString(){
        return String.format("Folder{id='%s'}",id);
    }

}
