package com.example.blog.controller;

import com.example.blog.model.dto.UserCreateDto;
import com.example.blog.model.entity.User;
import com.example.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        userService.saveUser(userCreateDto);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping(path = "{userId}")
    public void deleteMassage(@PathVariable("userId") Integer userid) {
        userService.deleteMassage(userid);
    }

    @PutMapping (path = "{userId}")
    public void updateMassage(
            @PathVariable("userId") Integer userId,
            @RequestParam(required = false) @Size(max = 50) @NotNull String email,
            @RequestParam(required = false) @Size(max = 50) @NotNull String password) {
        userService.updateMassage(userId, email, password);
    }
}
