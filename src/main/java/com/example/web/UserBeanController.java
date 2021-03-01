package com.example.web;

import com.example.demo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class UserBeanController {

    @GetMapping("/user")
    public User getUser(){
        User u = new User("To",12);
        return u;
    }
}
