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

    public String toString(){
        return String.format("Permission{user=%s, role=%s}",user.toString(),role);
    }

}
