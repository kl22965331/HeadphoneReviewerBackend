package com.example.demo.Util;

import com.example.demo.Exception.CustomException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import static java.lang.System.out;

@Component
public class JwtTokenFilter  extends OncePerRequestFilter{
    private JwtTokenGenerator jwtTokenGenerator;



    public JwtTokenFilter() {
    }

    @Autowired
    public JwtTokenFilter(JwtTokenGenerator jwtTokenGenerator) {

        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtTokenGenerator.resolveToken(request);
        try{
            if(token!=null && jwtTokenGenerator.isTokenValid(token)){
                Authentication authentication=jwtTokenGenerator.getAuthentication(token);
                out.println("認證是:"+authentication.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }catch (CustomException exception){
            SecurityContextHolder.clearContext();
            throw exception;
        }


        filterChain.doFilter(request,response);
    }
}
