package com.example.springboot.mongodb.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Student {

    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String email;
    private String gender;
    private List<String> favSubjects;


    public Student(String name, String email, String gender, List<String> favSubjects) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.favSubjects = favSubjects;
    }
}
