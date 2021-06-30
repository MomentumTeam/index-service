package Models;

import DriveStubs.grpc.PermissionOuterClass;
import Enums.ConvertRole;
import Enums.Role;
import Enums.UserExternalDest;
import Services.DataService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.ProtocolStringList;

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

    public void setAncestorId(@JsonProperty("ancestorId") String ancestorId) { this.ancestorId = ancestorId; }

    public static Permission [] getAllPermissions (String fileId, String userDest) throws Exception {  //with ancestors
        try {
            List<PermissionOuterClass.GetFilePermissionsResponse.UserRole> permissions;
            List<Permission> permissionList = new ArrayList<Permission>(
                    Arrays.asList(Permission.getSpecificPermissions(fileId, userDest)));
            ProtocolStringList ancestors = DataService.getAncestors(fileId).getAncestorsList();
            for (String ancestor : ancestors) {
                Permission[] ancestorPermissions = getSpecificPermissions(ancestor, userDest);
                permissionList.addAll(Arrays.asList(ancestorPermissions));
            }
            return Arrays.stream(permissionList.toArray()).toArray(Permission[]::new);
        } catch (Exception e){
            throw new Exception(String.format("Problem while receiving permissions of " +
                    "fileId='%s', error:%s", fileId, e.getMessage()));
        }
    }

    public static Permission [] getSpecificPermissions (String fileId, String userDest) throws Exception {  //with ancestors

        try {
            List<PermissionOuterClass.GetFilePermissionsResponse.UserRole> permissions = DataService.getPermissions(fileId).getPermissionsList();
            ArrayList<Permission> permissionList = new ArrayList<Permission>();
            for (PermissionOuterClass.GetFilePermissionsResponse.UserRole permission : permissions) {
            	Permission p;
            	if ((userDest.equals(UserExternalDest.CTS.name()) || userDest.equals(UserExternalDest.TOMCAL.name())) &&
            			permission.getCreator().equals(permission.getUserID())) {
            		p = new Permission(User.getUser(permission.getUserID(), userDest),
            				ConvertRole.get(permission.getRole()), fileId);
            	} else {
            		p = new Permission(User.getUser(permission.getUserID(), ""),
            				ConvertRole.get(permission.getRole()), fileId);
            	}
                permissionList.add(p);
            }
            return Arrays.stream(permissionList.toArray()).toArray(Permission[]::new);
        } catch (Exception e){
            throw new Exception(String.format("Problem while receiving permissions of " +
                    "fileId='%s', error:%s", fileId, e.getMessage()));
        }
    }

    @Override
    public String toString(){
        String userString = user == null ? "NULL":user.toString();
        return String.format("Permission{user=%s, role=%s}",user.toString(),role);
    }

}
