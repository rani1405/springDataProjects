package com.example.springdatajpa.Exception;

public class EmployeeNotFoundException extends Exception{

    private String message;

    public EmployeeNotFoundException(String message) {
        super(message);
    }


}
