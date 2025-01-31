package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Exception.CustomException;
import com.example.demo.Service.UserService;
import com.example.demo.ServiceImpl.EmailService;
import com.example.demo.Util.JwtTokenGenerator;
import com.example.demo.Util.Result;
import com.example.demo.Util.VerificationEmail;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private JwtTokenGenerator jwtTokenGenerator;
    private EmailService emailService;
    private Random random = new Random();
    private ConcurrentHashMap<String, VerificationEmail> verificationEmail=new ConcurrentHashMap();
    private static final String emailExpression="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


    @Autowired
    public UserController(UserService userService, JwtTokenGenerator jwtTokenGenerator,EmailService emailService) {
        this.userService = userService;
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.emailService=emailService;
    }
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserByUserId(id);
    }
    @GetMapping("/getByName")
    public User getUserByName(@RequestParam String username){
        User user = userService.getUserByUsername(username);
        String originEmail = user.getEmail();
        int atIndex = originEmail.indexOf("@");
        if(atIndex<3){
            String maskEmail="**"+originEmail.substring(atIndex);
            user.setEmail(maskEmail);
        }else {
            int midLength=atIndex-2;
            StringBuilder midString = new StringBuilder();
            for (int i = 0; i < midLength; i++) {
                midString.append("*");
            }

            String maskEmail=originEmail.substring(0,1)+midString.toString()+originEmail.substring(atIndex-1);
            user.setEmail(maskEmail);
        }
        return user;
    }
    @GetMapping("/getUseDetails")
    public User getUserWithSensitive(@RequestParam String username,HttpServletRequest request){
        if(Boolean.TRUE.equals(jwtTokenGenerator.isTokenValid(request))){
            throw new CustomException(400,"Invalid operation");
        }else {

            return userService.getUserByUsername(username);
        }
    }


    @GetMapping("/register")
    public Result register(@RequestParam String username,@RequestParam String password,@RequestParam String email){
        String regex = "^[a-zA-Z0-9]+$";
        Pattern usernamePasswordPattern = Pattern.compile(regex);
        Pattern emailPattern = Pattern.compile(emailExpression);
        if (!usernamePasswordPattern.matcher(username).matches() || !usernamePasswordPattern.matcher(password).matches()) {
            return Result.failedRusult("username和password只能包含英文字母和數字"); }
        User user = new User(username, password);
        user.setEmail(email);
        if(userService.isUsernamePresent(username)){
            return Result.failedRusult("username已存在,註冊失敗");
        }else if(!emailPattern.matcher(email).matches()){
            return Result.failedRusult("非法email");
        }else {

            int[] verifyIntCode=new int[4];
            for (int i = 0; i < 4; i++) {
                verifyIntCode[i]= random.nextInt(10);
            }
            String verifyStringCode= Arrays.stream(verifyIntCode).mapToObj(String::valueOf).collect(Collectors.joining());
            String subject="HeadphoneReviewer 認證信";
            String message="你好這裡是來自HeadphoneReviewer的認證信\n"+"你的認證碼為:"+verifyStringCode;


            VerificationEmail verificationEmailObject = new VerificationEmail(email, user, verifyIntCode);
            verificationEmail.put(username,verificationEmailObject);
            emailService.sendEmail(email,subject,message);


            return Result.successRusult("已註冊,待認證");
        }
    }
    @PostMapping("verifyemail")
    public Result verifyEmail(@RequestParam String username,@RequestBody int[] verifyIntCode){

        VerificationEmail verifyObject = verificationEmail.get(username);
        if(verifyObject==null ){
            return Result.failedRusult("請重新註冊");
        }else if(!verifyObject.isVaildTime()){
            return Result.failedRusult("驗證碼超時");
        } else if(Arrays.equals(verifyIntCode,verifyObject.getVerifyCode())){
            User user = verifyObject.getUser();
            user.setCreatedAt(LocalDateTime.now());
            userService.addUserWithUserRole(user);
            return Result.successRusult("註冊成功");
        }else {
            return Result.failedRusult("驗證碼失敗");
        }

    }

    @GetMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) throws CustomException {
        if (userService.isUsernamePasswordPresent(username, password)) {
            String token = JwtTokenGenerator.generateToken(username);
            response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            response.setHeader("username", username);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            throw new CustomException(HttpServletResponse.SC_UNAUTHORIZED, "錯誤的username或是password");
        }
    }

    @DeleteMapping("delete")
    public void deleteUser(HttpServletRequest request){
        String token = JwtTokenGenerator.resolveToken(request);

        String usernameForDelete = JwtTokenGenerator.extractUsername(token);
        userService.deleteUserByUsername(usernameForDelete);
    }
    @PutMapping("update")
    public void updateUser(@RequestBody User user,HttpServletRequest request){
        String token = JwtTokenGenerator.resolveToken(request);
        if(!JwtTokenGenerator.extractUsername(token).equals(user.getUsername())){
            throw new CustomException(400,"Invalid Operation");
        }
        userService.updatePasswordOrEmail(user);

    }
    @GetMapping("/tokenexpiredcheck")
    public boolean checkTokenExpired(HttpServletRequest request){
        if(request.getHeader(HttpHeaders.AUTHORIZATION).isBlank()){
            return false;
        }
        try {

            return JwtTokenGenerator.isTokenExpired(request.getHeader(HttpHeaders.AUTHORIZATION));
        }catch (ExpiredJwtException exception){
            return true;
        }

    }

}
