package br.com.raytsson.restwitchspringbootandjava.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    public static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String getMessage;

    public ExceptionResponse(Date timestamp, String message, String getMessage) {
        this.timestamp = timestamp;
        this.message = message;
        this.getMessage = getMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGetMessage() {
        return getMessage;
    }

    public void setGetMessage(String getMessage) {
        this.getMessage = getMessage;
    }
}
