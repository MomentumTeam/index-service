package Models;

import Enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.*;

public class Permission implements Serializable {
    private User user;
    private Role role;

    public Permission(@JsonProperty("user") User user,
                      @JsonProperty("role") Role role){
        System.out.println(user.getName() + " " +user.getName());
        this.user = user;
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }

    public void setRole(@JsonProperty("role") Role role) {
        this.role = role;
    }

    public void setUser(@JsonProperty("user") User user) {
        this.user = user;
    }

    public HashMap<String,Object> getHashMap(){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("user",user.getHashMap());
        map.put("role",role);
        return map;
    }

    public static Permission getRandom(){
        Random rand = new Random();
        User user = User.getRandom();
        Role role = rand.nextBoolean() ? Role.READ : Role.WRITE;
        return new Permission(user, role);
    }

    public static Permission [] getRandomArray(){
        Random rand = new Random();
        Permission [] permissions = new Permission[rand.nextInt(5)+1];
        for (int i = 0 ; i < permissions.length ; i++)
        {
            permissions[i] = Permission.getRandom();
        }
        return permissions;
    }
}
