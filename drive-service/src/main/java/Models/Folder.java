package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.Arrays;

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

    @Override
    public String toString(){
        return String.format("Folder{id='%s'}",id);
    }
}
