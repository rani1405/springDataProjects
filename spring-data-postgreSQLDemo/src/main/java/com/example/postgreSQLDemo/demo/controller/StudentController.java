package com.example.postgreSQLDemo.demo.controller;

import com.example.postgreSQLDemo.demo.dto.StudentResponseDTO;
import com.example.postgreSQLDemo.demo.entity.Student;
import com.example.postgreSQLDemo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));

    }

    @PostMapping("/save")
    public ResponseEntity<StudentResponseDTO> saveStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }


}
