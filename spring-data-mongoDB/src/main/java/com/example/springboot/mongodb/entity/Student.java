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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPhNo() {
        return phNo;
    }

    public void setPhNo(Integer phNo) {
        this.phNo = phNo;
    }

    public List<String> getFavSubjects() {
        return favSubjects;
    }

    public void setFavSubjects(List<String> favSubjects) {
        this.favSubjects = favSubjects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
