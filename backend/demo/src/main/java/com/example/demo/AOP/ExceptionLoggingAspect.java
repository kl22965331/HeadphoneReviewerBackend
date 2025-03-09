package com.example.demo.AOP;

import com.example.demo.DAO.ExceptionRepository;
import com.example.demo.Entity.ExceptionEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class ExceptionLoggingAspect {


    private ExceptionRepository exceptionRepository;

    @Autowired
    public ExceptionLoggingAspect(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    @Pointcut("within(com.example.demo.Controller..*)")
    public void controllerMethods() {}

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setExceptionMessage(ex.getMessage());
        exceptionEntity.setStackTrace(Arrays.toString(ex.getStackTrace()));
        exceptionEntity.setTimestamp(LocalDateTime.now());
        System.out.println(exceptionEntity.toString());
        exceptionRepository.save(exceptionEntity);
    }
}

