package com.example.blog.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCreateDto {

    @NotNull
    @Size(max = 50)
    private String name;
    @NotNull
    @Size(max = 1000)
    private String message;
}
