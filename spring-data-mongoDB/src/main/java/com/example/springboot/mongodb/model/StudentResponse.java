package com.example.springboot.mongodb.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentResponse {

    private String id;
    private String name;
    private String email;
    private String gender;
    private Integer phNo;
    private List<String> favSubjects;
}
