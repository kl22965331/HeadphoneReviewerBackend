package com.example.demo.Exception;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public SimpleResponse handleException(Exception exception, HttpServletResponse response) throws IOException {
        SimpleResponse simpleResponse = new SimpleResponse(response.getStatus(),"something wrong");
        return simpleResponse;
    }





}
