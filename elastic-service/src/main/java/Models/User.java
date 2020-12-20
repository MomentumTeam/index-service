package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {
    private String userId;
    private String name;
    private String hierarchy;

    public User(@JsonProperty("userId") String userId ,@JsonProperty("name") String name,
                @JsonProperty("hierarchy") String hierarchy){
        this.userId = userId;
        this.name = name;
        this.hierarchy = hierarchy;
    }

    public void setName(@JsonProperty("name") String name) {
        this.name = name;
    }

    public void setUserId(@JsonProperty("userId") String userId) {
        this.userId = userId;
    }

    public void setHierarchy(@JsonProperty("hierarchy") String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getName() {
        return name;
    }

    public String getUserId (){
        return this.userId;
    }

    public String getHierarchy (){
        return this.hierarchy;
    }

    public HashMap<String,String> getHashMap(){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("userId",userId);
        map.put("name",name);
        map.put("hierarchy",hierarchy);
        return map;
    }

    public static User getRandom() {
        Faker faker = new Faker();
        String userId = faker.idNumber().valid();
        String name = faker.name().fullName();
        String hierarchy = faker.name().username();
        User user = new User(userId, name, hierarchy);
        return user;
    }
}

