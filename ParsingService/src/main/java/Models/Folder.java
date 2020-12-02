package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;

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
}
