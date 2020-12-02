package Models;

import DriveStubs.grpc.PermissionOuterClass;
import Enums.ConvertRole;
import Enums.Role;
import Services.DataFromDrive;
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

//    public String toString (){
//        return this.role + " " this.user.getName() + this.user.getUserId();
//    }

    public static Permission [] getPermissions (String fileId) {

        List<PermissionOuterClass.GetFilePermissionsResponse.UserRole> permissions = DataFromDrive.getPermissions(fileId).getPermissionsList();
        ArrayList<Permission> permissionList = new ArrayList<Permission>();
        for (PermissionOuterClass.GetFilePermissionsResponse.UserRole permission : permissions){
            Permission p = new Permission(User.getUser(permission.getUserID()), ConvertRole.get(permission.getRole()));
            permissionList.add(p);
        }
        ProtocolStringList ancestors = DataFromDrive.getAncestors(fileId).getAncestorsList();
        for (String ancestor : ancestors){
            permissions = DataFromDrive.getPermissions(ancestor).getPermissionsList();
            for (PermissionOuterClass.GetFilePermissionsResponse.UserRole permission : permissions){
                Permission p = new Permission(User.getUser(permission.getUserID()),ConvertRole.get(permission.getRole()));
                Optional<Permission> optionalPermission = permissionList.stream().filter((Permission item) ->
                        item.getUser().getUserId().equals(p.getUser().getUserId())).findFirst();

                if(optionalPermission.isPresent()){
                    Permission existingPermission = optionalPermission.get();
                    if(existingPermission.role == Role.READ && p.role == Role.WRITE){
                        existingPermission.setRole(Role.WRITE);
                    }
                } else {
                    permissionList.add(p);
                }
            }
        }
        return Arrays.stream(permissionList.toArray()).toArray(Permission[]::new);
    }

}
