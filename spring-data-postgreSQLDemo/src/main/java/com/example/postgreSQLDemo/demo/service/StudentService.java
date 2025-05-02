package com.example.postgreSQLDemo.demo.service;

import com.example.postgreSQLDemo.demo.dto.StudentResponseDTO;
import com.example.postgreSQLDemo.demo.entity.Student;
import com.example.postgreSQLDemo.demo.exception.StudentNotFoundException;
import com.example.postgreSQLDemo.demo.mapper.StudentMapper;
import com.example.postgreSQLDemo.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentResponseDTO getStudentById(Long id) {
        Student studentResponse = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found exception"));
        return  studentMapper.getStudentResponse(studentResponse);
    }


    public StudentResponseDTO saveStudent(Student student) {
        Student studentResponse = studentRepository.save(student);
        return studentMapper.saveStudentResponse(studentResponse);
    }

}
