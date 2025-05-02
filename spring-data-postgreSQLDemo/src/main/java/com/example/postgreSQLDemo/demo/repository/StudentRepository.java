package com.example.postgreSQLDemo.demo.repository;

import com.example.postgreSQLDemo.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
