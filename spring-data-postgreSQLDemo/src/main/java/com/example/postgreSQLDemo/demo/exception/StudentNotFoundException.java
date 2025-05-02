package com.example.postgreSQLDemo.demo.exception;

public class StudentNotFoundException extends RuntimeException{

    private String message;

    public StudentNotFoundException(String message) {
        this.message = message;
    }

}
