package com.example.travel_project.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class ResponseData<T> implements Serializable {
    private final int status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseData( int status,String message, T data) {
        this.message = message;
        this.data = data;
        this.status = status;
    }
}
