package Models;

import Enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.*;

public class Permission implements Serializable {
    private User user;
    private Role role;
    private String ancestorId;

    public Permission(@JsonProperty("user") User user,
                      @JsonProperty("role") Role role,
                      @JsonProperty("ancestorId") String ancestorId){
        this.user = user;
        this.role = role;
        this.ancestorId = ancestorId;
    }

    public Role getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }

    public String getAncestorId() { return ancestorId; }

    public void setRole(@JsonProperty("role") Role role) {
        this.role = role;
    }

    public void setUser(@JsonProperty("user") User user) {
        this.user = user;
    }

    public void setUser(@JsonProperty("ancestorId") String ancestorId) { this.ancestorId = ancestorId; }

    @Override
    public String toString(){
        String userString = user == null ? "NULL":user.toString();
        return String.format("Permission{user=%s, role=%s}",user.toString(),role);
    }
}
