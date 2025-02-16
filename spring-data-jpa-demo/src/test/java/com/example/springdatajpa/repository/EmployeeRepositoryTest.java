package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUpData() {
        employee = Employee.builder()
                .id(1L)
                .empName("Rani")
                .empEmail("ranisarde@yahoo.com")
                .build();

        employeeRepository.save(employee);
    }

    @Test
    @Order(2)
    public void testFindByEmpName() {

        Optional<Employee> employeeResponse = employeeRepository.findByEmpName(employee.getEmpName());
        assertEquals(employee.getEmpName(), employeeResponse.get().getEmpName());
        assertThat(employeeResponse.get().getId()).isGreaterThan(0);
    }
}
