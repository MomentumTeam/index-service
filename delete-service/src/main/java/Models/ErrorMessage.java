package Models;

import Enums.ErrorOperation;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {
    private String fileId;
    private ErrorOperation operation;
    public ErrorMessage(@JsonProperty("fileId") String fileId,
                        @JsonProperty("operation") ErrorOperation operation){
        this.fileId = fileId;
        this.operation = operation;
    }

    public ErrorOperation getOperation() {
        return operation;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setOperation(ErrorOperation operation) {
        this.operation = operation;
    }

    @Override
    public String toString(){
        return "ErrorMessage{ fileId='" + fileId + "' , operation='" + operation + "'}";
    }


}
