package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


     Optional<Employee> findByEmpName(String empName);

}
