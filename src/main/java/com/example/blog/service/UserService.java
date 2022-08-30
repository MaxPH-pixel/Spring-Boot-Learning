package com.example.blog.service;

import com.example.blog.model.dto.UserCreateDto;
import com.example.blog.model.entity.User;

import java.util.List;

public interface UserService {
    public User saveUser(UserCreateDto userCreateDto);
    public List<User> getAllUsers();
    public void deleteMassage(Integer id);
    public void updateMassage(Integer id, String massage);
}
