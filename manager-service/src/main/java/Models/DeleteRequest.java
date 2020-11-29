package Models;

import Enums.MessageEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;

public class DeleteRequest {
    public String fileId;
    public boolean createAfter;

    public DeleteRequest(@JsonProperty("fileId") final String fileId ,
                         @JsonProperty("createAfter")final boolean createAfter)
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


}
