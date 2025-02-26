package com.example.demo.Util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static Result successRusult(String message){
        return new Result(true,message);
    }
    public static Result failedRusult(String message){
        return new Result(false,message);
    }

    @Override
    public String toString() {
       if(success){
           return "操作成功("+this.getMessage()+")";
       }else {
           return "操作失敗("+this.getMessage()+")";
       }

    }
}
