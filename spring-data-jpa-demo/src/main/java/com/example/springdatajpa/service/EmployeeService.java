package com.example.springdatajpa.service;

import com.example.springdatajpa.Exception.EmployeeNotFoundException;
import com.example.springdatajpa.entity.Department;
import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee employeeWithTheirDepts(Long empId) throws EmployeeNotFoundException {
        return employeeRepository.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public Employee employeeByEmployeeName(String empName) throws EmployeeNotFoundException {
        return employeeRepository.findByEmpName(empName).orElseThrow(() -> new EmployeeNotFoundException("Employee not found for given employee name"));
    }

    public Page<Employee> allEmployeesWithTheirDepts() {
           return employeeRepository.findAll(Pageable.ofSize(5));
    }


    public Employee saveEmployeeWithDepts(Employee employee) {
        for (Department department : employee.getDepartmentSet()) {
            department.setEmployee(employee);
        }
         return employeeRepository.save(employee);
    }


    public void deleteEmployeeWithDepts(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
