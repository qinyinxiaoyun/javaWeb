package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class proxyBeanTest {

    @Autowired
    @Qualifier("u1")
    User u1;

    @Autowired
    @Qualifier("u1")
    User u2;

    @Test
    public void test(){
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u1==u2);
    }
}
