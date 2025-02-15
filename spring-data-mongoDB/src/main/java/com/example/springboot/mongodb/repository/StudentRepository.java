package com.example.springboot.mongodb.repository;

import com.example.springboot.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {

    Optional<Student> findStudentByEmail(String email);

    void deleteByEmail(String email);
}
