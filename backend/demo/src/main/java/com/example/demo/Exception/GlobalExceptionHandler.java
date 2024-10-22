package com.example.demo.Exception;


import com.example.demo.Exception.SimpleResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception,HttpServletResponse response) throws IOException {
        SimpleResponse simpleResponse = new SimpleResponse(response.getStatus(),exception.getMessage());
        return simpleResponse.toString();
    }





}
