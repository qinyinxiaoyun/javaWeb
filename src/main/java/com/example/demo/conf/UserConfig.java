package com.example.demo.conf;

import com.example.demo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean(name = "u1")
    public User getU1(){
        User u1 = new User();
        return u1;
    }

    @Bean(name = "u2")
    public User getU2(){
        return new User();
    }
}
