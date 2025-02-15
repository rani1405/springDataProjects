package com.example.springboot.mongodb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String email;
    private String gender;
    private Integer phNo;
    private List<String> favSubjects;
    private Address address;


    public Student(String name, String email, String gender, Integer phNo, List<String> favSubjects, Address address) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phNo = phNo;
        this.favSubjects = favSubjects;
        this.address = address;
    }
}
