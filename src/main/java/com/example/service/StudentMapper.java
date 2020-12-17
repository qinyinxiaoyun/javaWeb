package com.example.service;

import com.example.demo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;


//@Mapper
@Service
public interface StudentMapper {
    @Select("SELECT * FROM STUDENT WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO STUDENT(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
