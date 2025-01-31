package com.example.demo.Util;

import com.example.demo.Exception.CustomException;
import com.example.demo.Exception.IncorrectJwtTokenException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



@Component
public class JwtTokenFilter  extends OncePerRequestFilter{
    private JwtTokenGenerator jwtTokenGenerator;
    private final List<String> whiteList= Arrays.asList("/user/verifyemail");


    public JwtTokenFilter() {
    }

    @Autowired
    public JwtTokenFilter(JwtTokenGenerator jwtTokenGenerator) {

        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getMethod().equals(HttpMethod.GET.name()) || isWhitePath(request)){
            filterChain.doFilter(request,response);
            return;
        }




        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header==null || header.isEmpty()) {
            throw new CustomException("請重新登入或註冊");
        }
        String token = jwtTokenGenerator.resolveToken(request);
        try{
            if(token!=null && jwtTokenGenerator.isTokenValid(token)){
                Authentication authentication=jwtTokenGenerator.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }catch (Exception exception){
            SecurityContextHolder.clearContext();
            throw new IncorrectJwtTokenException(200,"請重新登入");
        }


        filterChain.doFilter(request,response);
    }
    private boolean isWhitePath(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        return whiteList.stream().anyMatch(requestURI::startsWith);
    }
}
