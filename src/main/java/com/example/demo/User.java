package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class User {


    private String name;

    @NotNull
    @Max(100)
    private Integer age;

}