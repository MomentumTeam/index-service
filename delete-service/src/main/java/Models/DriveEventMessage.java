package Models;

import Enums.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.ParseException;

public class DriveEventMessage implements Serializable {
    public final String fileId;
    public final MessageEvent event;

    public DriveEventMessage(@JsonProperty("fileId") final String fileId,
                             @JsonProperty("event")final MessageEvent event) throws ParseException {
        this.fileId = fileId;
        this.event = event;
    }

    public String getFileId() { return fileId;}

    public MessageEvent getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Message{" +
                "fileId='" + fileId + '\'' +
                ", event=" + event +
                '}';
    }
}
