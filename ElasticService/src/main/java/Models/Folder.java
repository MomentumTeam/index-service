package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.HashMap;

public class Folder implements Serializable {

    private String name;
    private String id;

    public Folder(@JsonProperty("name") String name, @JsonProperty("id") String id){
        this.name = name;
        this.id = id;
    }

    public static Folder getRandom(){
        Faker faker = new Faker();
        String name = faker.color().name();
        String id = faker.idNumber().valid();
        return new Folder(name, id);
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
        map.put("name",this.name);
        return map;
    }
}
