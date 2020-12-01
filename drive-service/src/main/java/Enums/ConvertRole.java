package Enums;

import DriveStubs.grpc.PermissionOuterClass;


public class ConvertRole {

    public static Role get(DriveStubs.grpc.PermissionOuterClass.Role role) {
        if (role.equals(PermissionOuterClass.Role.READ))
            return Role.READ;
        if (role.equals(PermissionOuterClass.Role.WRITE))
            return Role.WRITE;
        return Role.NONE;
    }
}
