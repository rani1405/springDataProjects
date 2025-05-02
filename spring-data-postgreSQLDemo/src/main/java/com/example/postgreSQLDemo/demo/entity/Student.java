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

    @ElementCollection
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "stud_id", referencedColumnName = "id"))
    private List<Address> addressList;

    private

}
