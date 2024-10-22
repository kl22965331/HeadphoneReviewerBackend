package com.example.demo.Configuration;

import org.springframework.web.servlet.config.annotation.*;

public class WebConfiguration implements WebMvcConfigurer{

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8081");
            }
        };
    }



}
