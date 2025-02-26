package com.example.demo.Util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityContextUtil {
    public static String getCurrentUsername(){
        UserDetails currentDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return currentDetails.getUsername();
    }
}
