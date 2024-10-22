package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Exception.CustomException;
import com.example.demo.Service.UserService;
import com.example.demo.Util.JwtTokenGenerator;
import com.example.demo.Util.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class LoginController {

    private UserService userService;



    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password){
        User user = new User(username, password);
        if(userService.isUsernamePresent(username)){
            return Result.failedRusult("username已存在,註冊失敗").toString();
        }else {
            user.setCreatedAt(LocalDateTime.now());
            userService.addUser(user);

            return Result.successRusult("註冊成功").toString();
        }
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) throws CustomException {
        if(userService.isUsernamePasswordPresent(username,password)){
            String token = JwtTokenGenerator.generateToken(username);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,"Bearer "+token).build();
        }else{
        throw new CustomException(response.getStatus(),"錯誤的username或是password");
        }


    }
}
