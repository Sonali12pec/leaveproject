package com.example.sonaliproject.model.response;

import lombok.Data;

@Data
public class GenericResponse<T> {

    private T data;
    private Exception exception;
    private String message;
    private String status;
}
