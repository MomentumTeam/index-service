package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RabbitErrorMassage {
    private String fileId;
    public RabbitErrorMassage(@JsonProperty("fileId") String fileId){
        this.fileId = fileId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
