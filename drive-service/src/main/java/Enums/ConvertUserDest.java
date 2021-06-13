package Enums;

import Enums.UserExternalDest;
import Enums.FileAppID;

public class ConvertUserDest {

    public static String get(String appID) {
        if (appID.equals(FileAppID.dropbox.name()))
            return UserExternalDest.TOMCAL.name();
        if (appID.equals(FileAppID.cargo.name()))
            return UserExternalDest.CTS.name();
        return "";
    }
}
