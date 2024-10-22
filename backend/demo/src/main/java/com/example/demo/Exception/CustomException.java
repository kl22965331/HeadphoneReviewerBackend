package com.example.demo.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;



public class CustomException extends RuntimeException{


    private  int httpStatus;
    private  String message;

    public CustomException(){
        this.httpStatus=200;
        this.message="ok";
    }

    public CustomException(String message) {
        super(message);

    }

    public CustomException(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }



    @Override
    public String getMessage() {
        return message;
    }
}
