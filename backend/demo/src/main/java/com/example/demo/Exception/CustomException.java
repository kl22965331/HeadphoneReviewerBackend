package com.example.demo.Exception;

public class CustomException extends RuntimeException{


    private  int httpStatus=200;
    private  String message;

    public CustomException(){
        this.message="ok";
    }

    public CustomException(String message) {
        super(message);

    }


    public CustomException(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
    public int getHttpStatus(){return httpStatus;}



    @Override
    public String getMessage() {
        return message;
    }
}
