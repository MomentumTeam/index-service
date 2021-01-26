package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.ParseException;

public class DeleteRequest implements Serializable{
    public String fileId;

    public DeleteRequest(@JsonProperty("fileId") String fileId)
            throws ParseException{
        this.fileId = fileId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString(){
        return "DeleteRequest{fileId='" + fileId + "'}";
    }

}
