package com.example.demo.Exception;

public class IncorrectJwtTokenException extends RuntimeException{

    private int status;
    private  String message;

    public IncorrectJwtTokenException(int status,String message) {
        this.status = status;
        this.message=message;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
