package com.example.springboot.mongodb.controller;

import com.example.springboot.mongodb.entity.Student;
import com.example.springboot.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-student-by-email/{email}")
    public ResponseEntity<Student> studentByEmail(@PathVariable String email) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.studentByEmail(email));
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> allStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.allStudents());
    }


    @PostMapping("/save-student")
    public ResponseEntity saveStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(studentService.saveStudent(student));
    }

    @DeleteMapping("/delete-student-by-email/{email}")
    public ResponseEntity deleteStudentByEmail(@PathVariable String email) {
        studentService.deleteStudentByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
