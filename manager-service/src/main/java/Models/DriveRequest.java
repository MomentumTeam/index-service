package Models;

import Enums.DriveField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import java.io.Serializable;

public class DriveRequest implements Serializable {
    public String fileId;
    public DriveField[] driveFields;

    public DriveRequest(@JsonProperty("fileId") final String fileId ,
                        @JsonProperty("driveFields")final DriveField[] driveFields){
        this.fileId = fileId;
        this.driveFields = driveFields;
    }

    public String getFileId() {
        return fileId;
    }

    public DriveField[] getDriveFields() {
        return driveFields;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setDriveFields(DriveField[] driveFields) {
        this.driveFields = driveFields;
    }
}
