package com.example.sonaliproject.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("stackTrace")
public class ValidationException extends RuntimeException {

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Exception ex) {
        super(ex);
    }

    public ValidationException(String message, Throwable e) {
        super(message, e);
    }

    public ValidationException() {
        super();
    }


}
