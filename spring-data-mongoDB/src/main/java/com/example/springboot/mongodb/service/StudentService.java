package com.example.springboot.mongodb.service;

import com.example.springboot.mongodb.entity.Student;
import com.example.springboot.mongodb.mapper.StudentRequestMapper;
import com.example.springboot.mongodb.model.StudentResponse;
import com.example.springboot.mongodb.model.StudentXMLResponseDTO;
import com.example.springboot.mongodb.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRequestMapper studentRequestMapper;

    @Value("${spring.application.name}")
    private String appName;
    public StudentResponse studentByEmail(String email) throws Exception {
       Student student = studentRepository.findStudentByEmail(email).orElseThrow(() -> new Exception("Student not found"));

        return studentRequestMapper.getStudentResponse(student);
    }

    public List<Student> allStudents() {
        System.out.println("app name --"+ appName );
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    public void deleteStudentByEmail(String email) {
        studentRepository.deleteByEmail(email);
    }


    public StudentXMLResponseDTO studentByEmailXMLResponse(String email) throws Exception {
        Student student = studentRepository.findStudentByEmail(email).orElseThrow(() -> new Exception("Student not found"));

        return studentRequestMapper.returnStudentResponseInXmlFormat(student);
    }

}
