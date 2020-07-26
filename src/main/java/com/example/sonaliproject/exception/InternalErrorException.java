package com.example.sonaliproject.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("stackTrace")
public class InternalErrorException extends RuntimeException {


    public InternalErrorException(Throwable cause) {
        super(cause);
    }

    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(Exception ex) {
        super(ex);
    }

    public InternalErrorException(String message, Throwable e) {
        super(message, e);
    }

    public InternalErrorException() {
        super();
    }


}
