package com.example.springdatajpa.service;

import com.example.springdatajpa.Exception.EmployeeNotFoundException;
import com.example.springdatajpa.entity.Department;
import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {


    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    Employee employee;

    Department department;

    Page<Employee> employeePage;

    @BeforeEach
    public void setUpData() {

        department = Department.builder()
                .id(2L)
                .deptName("Computer Science").build();

        Set departmetSet = new HashSet<>();
        departmetSet.add(department);

        employee = Employee.builder()
                .id(1L)
                .empName("Rani")
                .empEmail("ranisarde@yahoo.com")
                .departmentSet(departmetSet)
                .build();

        employeePage = new PageImpl<>(List.of(employee), PageRequest.of(0, 10), 2);

    }


    @Test
    public void testEmployeeWithTheirDepts() throws EmployeeNotFoundException {
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        Employee employeeResponse = employeeService.employeeWithTheirDepts(employee.getId());

        assertEquals(employee.getId(), employeeResponse.getId());
        assertEquals(employee.getEmpEmail(), employeeResponse.getEmpEmail());
    }

    @Test
    public void testSaveEmployeeWithDepts() throws EmployeeNotFoundException {
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee employeeResponse = employeeService.saveEmployeeWithDepts(employee);

        assertEquals(employee.getId(), employeeResponse.getId());
        assertEquals(employee.getEmpEmail(), employeeResponse.getEmpEmail());
        assertThat(employeeResponse).isNotNull();
    }

    @Test
    public void testDeleteEmployeeWithDepts() throws EmployeeNotFoundException {
        doNothing().when(employeeRepository).deleteById(employee.getId());

        employeeService.deleteEmployeeWithDepts(employee.getId());

        //This line verify how many times deleteById method called.
        verify(employeeRepository, times(1)).deleteById(employee.getId());
    }

    @Test
    public void testAllEmployeesWithTheirDepts() throws EmployeeNotFoundException {
        when(employeeRepository.findAll(Pageable.ofSize(5))).thenReturn(employeePage);

        Page<Employee> employeePageResponse = employeeService.allEmployeesWithTheirDepts();

        assertEquals(employeePageResponse.getSize(), 10L);
        assertThat(employeePageResponse).isNotNull();
    }
}
