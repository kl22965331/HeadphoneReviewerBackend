package com.example.demo.Service;

import com.example.demo.Entity.User;


public interface UserService {
    public User getUserByUserId(int id);
    public User getUserByUsername(String username);
    public void addUserWithUserRole(User user);

    public void updatePasswordOrEmail(User user);
    public void deleteUserById(int id);
    public void deleteUserByUsername(String username);

    boolean isUsernamePresent(String username);

    boolean isUsernamePasswordPresent(String username, String password);
}

