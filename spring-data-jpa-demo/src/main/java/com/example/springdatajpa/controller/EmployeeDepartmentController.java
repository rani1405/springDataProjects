package com.example.springdatajpa.controller;

import com.example.springdatajpa.Exception.EmployeeNotFoundException;
import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeDepartmentController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Spring Data JPA Demo");
    }


    @GetMapping("/employeeWithDepts/{empId}")
    public ResponseEntity<Employee> employeeWithTheirDepts(@PathVariable Long empId) throws EmployeeNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.employeeWithTheirDepts(empId));
    }

    @GetMapping("/employeeByEmpName/{empName}")
    public ResponseEntity<Employee> employeeByEmployeeName(@PathVariable String empName) throws EmployeeNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.employeeByEmployeeName(empName));
    }

    @GetMapping("/employeeWithDepts")
    public ResponseEntity<Page<Employee>> allEmployeesWithTheirDepts() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.allEmployeesWithTheirDepts());
    }


    @PostMapping("/employeeWithDepts")
    public ResponseEntity<Employee> saveEmployeeWithDepts(@Validated @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployeeWithDepts(employee));
    }


    @DeleteMapping("/employeeWithDepts/{empId}")
    public ResponseEntity deleteEmployeeWithDepts(@PathVariable Long empId) {
        employeeService.deleteEmployeeWithDepts(empId);
        return ResponseEntity.noContent().build();
    }

}
