package com.example.demo.Service;

import com.example.demo.Entity.User;


public interface UserService {
    public void addUser(User user);

    boolean isUsernamePresent(String username);

    boolean isUsernamePasswordPresent(String username, String password);
}

