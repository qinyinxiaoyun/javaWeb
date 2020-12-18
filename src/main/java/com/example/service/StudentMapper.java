package com.example.service;

import com.example.demo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;


//@Mapper
@Service
public interface StudentMapper {
    @Select("SELECT * FROM STUDENT WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO STUDENT(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE STUDENT SET age=#{age} WHERE name=#{name}")
    void update(Student student);

    @Delete("DELETE FROM STUDENT WHERE id =#{id}")
    void delete(Long id);
}
