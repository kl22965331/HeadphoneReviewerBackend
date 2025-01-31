package com.example.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AuthorityCheckAspect {
    Logger logger=LoggerFactory.getLogger(AuthorityCheckAspect.class);

    @AfterReturning("execution(* org.springframework.security.web.FilterChainProxy.doFilter(..))")
    public void checkAuthorities(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println("User: " + authentication.getName());
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                System.out.println("Authority: " + authority.getAuthority());
            }
        } else {
            System.out.println("No authentication present in SecurityContextHolder.");
        }
    }
}

