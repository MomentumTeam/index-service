package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    public User(Map<String,Object> map){
        this.userId = (String) (map.get("userId"));
        this.name = (String) (map.get("name"));
        this.hierarchy = (String) (map.get("hierarchy"));
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

    @Override
    public String toString(){
        return String.format("User{userId='%s', name='%s', hierarchy='%s'}",
                userId, name, hierarchy);
    }
}

