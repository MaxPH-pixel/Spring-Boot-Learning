package com.example.blog.service;

import com.example.blog.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public void deleteMassage(Integer id);
    public void updateMassage(Integer id, String massage);
}
