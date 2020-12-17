package com.example.web;

import com.example.demo.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class UserServiceController {

    @Resource
    private UserService userService;

    @GetMapping("/list/{name}")
    public List<User> getUser(@PathVariable String name){
        return userService.getByName(name);
    }
}
