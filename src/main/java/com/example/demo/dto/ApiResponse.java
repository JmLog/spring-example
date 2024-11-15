package com.example.demo.dto;

public class ApiResponse<T> {
    private boolean result;
    private String message;
    private T data;

    public ApiResponse(boolean result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }
}
