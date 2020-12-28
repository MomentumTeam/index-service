package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;

public class Folder implements Serializable {

    private String id;

    public Folder(@JsonProperty("name") String name, @JsonProperty("id") String id){
        this.id = id;
    }

    public String toString(){
        return String.format("Folder{id='%s'}",id);
    }
}
