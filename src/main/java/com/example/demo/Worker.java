package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Worker implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;
    Worker(String name,Integer age){
        this.name = name;
        this.age = age;
    }
}
