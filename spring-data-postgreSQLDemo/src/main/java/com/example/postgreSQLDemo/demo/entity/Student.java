package com.example.postgreSQLDemo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "emailAddress", columnDefinition = "text[]")
    private List<String> emailAddress;

    @Embedded
    private Address address;

}
