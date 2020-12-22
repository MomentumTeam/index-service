package Models;

import DriveStubs.grpc.UsersOuterClass;
import Services.DataService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.io.Serializable;

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

    public static User getRandom() {
        Faker faker = new Faker();
        String userId = faker.idNumber().valid();
        String name = faker.name().fullName();
        String hierarchy = faker.name().username();
        User user = new User(userId, name, hierarchy);
        return user;
    }

    public static User getUser(String userId){
        UsersOuterClass.User user = DataService.getUser(userId);
        String name = user.getFullName();
        String hierarchy = user.getHierarchyFlat();
        return new User(userId, name, hierarchy);
    }

    @Override
    public String toString(){
        return String.format("User { userId='%s' , name='%s', hierarchy='%s'}",
                userId, name, hierarchy);
    }
}

