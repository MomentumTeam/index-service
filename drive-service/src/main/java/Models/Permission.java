package Models;

import DriveStubs.grpc.PermissionOuterClass;
import Enums.ConvertRole;
import Enums.Role;
import Services.DataService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.ProtocolStringList;

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

    public static Permission [] getPermissions (String fileId) throws Exception {

        try {
            List<PermissionOuterClass.GetFilePermissionsResponse.UserRole> permissions = DataService.getPermissions(fileId).getPermissionsList();
            ArrayList<Permission> permissionList = new ArrayList<Permission>();
            for (PermissionOuterClass.GetFilePermissionsResponse.UserRole permission : permissions) {
                Permission p = new Permission(User.getUser(permission.getUserID()), ConvertRole.get(permission.getRole()));
                permissionList.add(p);
            }
            ProtocolStringList ancestors = DataService.getAncestors(fileId).getAncestorsList();
            for (String ancestor : ancestors) {
                permissions = DataService.getPermissions(ancestor).getPermissionsList();
                for (PermissionOuterClass.GetFilePermissionsResponse.UserRole permission : permissions) {
                    Permission p = new Permission(User.getUser(permission.getUserID()), ConvertRole.get(permission.getRole()));
                    Optional<Permission> optionalPermission = permissionList.stream().filter((Permission item) ->
                            item.getUser().getUserId().equals(p.getUser().getUserId())).findFirst();

                    if (optionalPermission.isPresent()) {
                        Permission existingPermission = optionalPermission.get();
                        if (existingPermission.role == Role.READ && p.role == Role.WRITE) {
                            existingPermission.setRole(Role.WRITE);
                        }
                    } else {
                        permissionList.add(p);
                    }
                }
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
