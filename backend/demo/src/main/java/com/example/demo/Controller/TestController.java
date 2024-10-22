package com.example.demo.Controller;

import com.example.demo.Util.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private JwtTokenGenerator jwtTokenGenerator;
    private UserDetailsService userDetailsService;

    @Autowired
    public TestController(JwtTokenGenerator jwtTokenGenerator, UserDetailsService userDetailsService) {
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/test")
    public String validate(){
        return userDetailsService.loadUserByUsername("test").getAuthorities().toString();

    }
}
