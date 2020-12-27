package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.ParseException;

public class DeleteRequest implements Serializable{
    public String fileId;
    public boolean createAfter;

    public DeleteRequest(@JsonProperty("fileId") String fileId ,
                         @JsonProperty("createAfter") boolean createAfter)
            throws ParseException{
        this.fileId = fileId;
        this.createAfter = createAfter;
    }

    public String getFileId() {
        return fileId;
    }
    public boolean getCreateAfter() {
        return createAfter;
    }

    public void setCreateAfter(boolean createAfter) {
        this.createAfter = createAfter;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString(){
        return "DeleteRequest{fileId='" + fileId + "', createAfter='" + createAfter + "'}";
    }

}
