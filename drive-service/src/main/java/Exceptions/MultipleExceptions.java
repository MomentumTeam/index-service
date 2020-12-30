package Exceptions;

import java.util.ArrayList;
import java.util.HashMap;

public class MultipleExceptions extends Exception{
    public HashMap<String,ArrayList<String>> fileIdToErrorMessage;

    public MultipleExceptions(){
        super();
        fileIdToErrorMessage = new HashMap<String,ArrayList<String>>();
    }

    public void add(String fileId , String errorMessage){
        ArrayList<String> errorMessages;
        if(this.fileIdToErrorMessage.containsKey(fileId)){
            errorMessages = this.fileIdToErrorMessage.get(fileId);
            errorMessages.add(errorMessage);
        }
        else{
            errorMessages = new ArrayList<String>();
            errorMessages.add(errorMessage);
            this.fileIdToErrorMessage.put(fileId, errorMessages);
        }
    }

    public HashMap<String, ArrayList<String>> getFileIdToErrorMessage() {
        return fileIdToErrorMessage;
    }

    public void setFileIdToErrorMessage(HashMap<String, ArrayList<String>> fileIdToErrorMessage) {
        this.fileIdToErrorMessage = fileIdToErrorMessage;
    }

    public String toString(){
        String s = "";
        for(String fileId : this.fileIdToErrorMessage.keySet()){
            s = s + String.format("fileId='%s', Errors=%s\n",fileId,
                    this.fileIdToErrorMessage.get(fileId));
        }
        return s;
    }
}
