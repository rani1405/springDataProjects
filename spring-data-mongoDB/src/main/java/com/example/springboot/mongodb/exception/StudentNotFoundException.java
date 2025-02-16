package com.example.springboot.mongodb.exception;

public class StudentNotFoundException extends Exception {

    private String message;

    public StudentNotFoundException(String message) {
        super(message);
    }
}
