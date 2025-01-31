package com.example.demo.Util;

import com.example.demo.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;


@Getter
@Setter
public class VerificationEmail {
    private String email;
    private long validTime;
    private User user;
    private int[] verifyCode;

    public VerificationEmail(String email,User user,int[] verifyCode) {
        this.email = email;
        this.validTime=System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(10);
        this.user=user;
        this.verifyCode=verifyCode;
    }
    public boolean isVaildTime(){
        long current = System.currentTimeMillis();
        return validTime>current;
    }
}
