package com.example.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.example.demo.Util.JwtTokenGenerator.*(..))", throwing = "ex")
    public void handleException(JoinPoint point, Exception ex) {
        String name = point.getSignature().getName();
        System.out.println("catched exception: " + ex.getMessage()+"at:=>"+name);
    }
}