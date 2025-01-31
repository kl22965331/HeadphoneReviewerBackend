package com.example.demo.AOP;

import com.example.demo.Service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class ControllerAspect {
    private LogService logService;

    @Autowired
    public ControllerAspect(LogService logService) {
        this.logService = logService;
    }

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
    private static final DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Before("execution(public * com.example.demo.Controller.*.*(..))")
    public void loggingAllController(JoinPoint joinPoint){
        LocalDateTime now = LocalDateTime.now();
        String methodName = joinPoint.getSignature().getName();
        String name = joinPoint.getTarget().getClass().getSimpleName();
        String message=name+"."+methodName+" 被調用";
        logger.info("{}被調用 ---Time:{}",methodName,now);
        logService.saveLog("INFO",message,now);

    }
}
