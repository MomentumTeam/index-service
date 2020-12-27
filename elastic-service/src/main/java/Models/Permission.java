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

    public static String[] indicesByPermissions(Permission[] permissions){
        ArrayList<String> indicesList = new ArrayList<String>();
        for(Permission permission : permissions){
            User user = permission.getUser();
            if(user != null && permission.getRole() == Role.WRITE)
            indicesList.add(user.getUserId());
        }
        return Arrays.stream(indicesList.toArray()).toArray(String[]::new);
    }

    @Override
    public String toString(){
        String userString = user == null ? "NULL":user.toString();
        return String.format("Permission{user=%s, role=%s}",user.toString(),role);
    }

}
