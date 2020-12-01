package Models;

import DriveStubs.grpc.UsersOuterClass;
import Services.DataFromDrive;
import com.github.javafaker.Faker;

import java.util.HashMap;

public class User {
    private String userId;
    private String name;
    private String hierarchy;

    public User(String userId , String name, String hierarchy){
        this.userId = userId;
        this.name = name;
        this.hierarchy = hierarchy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setHierarchy(String hierarchy) {
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

    public static User getUser(String userId){
        UsersOuterClass.User user = DataFromDrive.getUser(userId);
        String name = user.getFullName();
        String hierarchy = user.getHierarchyFlat();
        return new User(userId, name, hierarchy);
    }
}

