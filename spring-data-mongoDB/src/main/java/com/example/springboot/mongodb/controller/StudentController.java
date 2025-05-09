package com.example.springboot.mongodb.controller;

import com.example.springboot.mongodb.entity.Student;
import com.example.springboot.mongodb.model.StudentResponse;
import com.example.springboot.mongodb.model.StudentXMLResponseDTO;
import com.example.springboot.mongodb.openapi.StudentApi;
import com.example.springboot.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController implements StudentApi {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-student-by-email/{email}")
    public ResponseEntity<StudentResponse> studentByEmail(@PathVariable String email) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.studentByEmail(email));
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> allStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.allStudents());
    }


    @PostMapping("/save-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }


    @DeleteMapping("/delete-student-by-email/{email}")
    public ResponseEntity deleteStudentByEmail(@PathVariable String email) {
        studentService.deleteStudentByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/get-student-by-email-xml-response/{email}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<StudentXMLResponseDTO> studentByEmailXMLResponse(@PathVariable String email) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.studentByEmailXMLResponse(email));
    }


}
