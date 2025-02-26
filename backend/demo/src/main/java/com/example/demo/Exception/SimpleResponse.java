package com.example.demo.Exception;


import org.springframework.stereotype.Component;

@Component
public class SimpleResponse {
    private int status;
    private String message;

    public SimpleResponse() {
    }

    public SimpleResponse (int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return status +"-"+message;
    }
}
