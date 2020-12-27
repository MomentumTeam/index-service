package RabbitModels;

import Enums.DriveField;
import Enums.ElasticOperation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;

public class DriveRequest implements Serializable {
    public String fileId;
    public DriveField[] driveFields;
    public ElasticOperation elasticOperation;


    public DriveRequest(@JsonProperty("fileId") final String fileId ,
                        @JsonProperty("driveFields")final DriveField[] driveFields,
                        @JsonProperty("elasticOperation")final ElasticOperation elasticOperation){
        this.fileId = fileId;
        this.driveFields = driveFields;
        this.elasticOperation = elasticOperation;
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

    public ElasticOperation getElasticOperation() {
        return elasticOperation;
    }

    public void setElasticOperation(ElasticOperation elasticOperation) {
        this.elasticOperation = elasticOperation;
    }

    public String toString(){
        return String.format("DriveRequest{fileId='%s', driveFields='%s', elasticOperation='%s'}",
                fileId, Arrays.toString(driveFields),elasticOperation);
    }
}
