package com.example.demo;

import com.example.service.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@MapperScan(basePackages = {"com.example.service"})
public class StudentTest {

        @Autowired
        private StudentMapper studentMapper;

        @Test
        @Rollback
        public void test() throws Exception {
            // insert一条数据，并select出来验证
            studentMapper.insert("AA", 20);
            Student u = studentMapper.findByName("AAA");
            Assert.assertEquals(20, u.getAge().intValue());
            // update一条数据，并select出来验证
            u.setAge(30);
            studentMapper.update(u);
            u = studentMapper.findByName("AAA");
            Assert.assertEquals(30, u.getAge().intValue());
            // 删除这条数据，并select验证
            studentMapper.delete(u.getId());
            u = studentMapper.findByName("AAA");
            Assert.assertEquals(null, u);
        }

}

