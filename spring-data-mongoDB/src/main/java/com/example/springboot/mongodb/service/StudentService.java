package com.example.springboot.mongodb.service;

import com.example.springboot.mongodb.entity.Student;
import com.example.springboot.mongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student studentByEmail(String email) throws Exception {
       return studentRepository.findStudentByEmail(email).orElseThrow(() -> new Exception("Student not found"));
    }

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    public void deleteStudentByEmail(String email) {
        studentRepository.deleteByEmail(email);
    }

}
