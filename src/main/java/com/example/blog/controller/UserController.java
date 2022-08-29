package com.example.blog.controller;

import com.example.blog.model.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "New message is added";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping(path = "{userId}")
    public void deleteMassage(@PathVariable("userId") Integer userid) {
        userService.deleteMassage(userid);
    }

    @PutMapping(path = "{userId}")
    public void updateMassage(
            @PathVariable("userId") Integer userId,
            @RequestParam(required = false) String massage){
        userService.updateMassage(userId, massage);
    }
}
