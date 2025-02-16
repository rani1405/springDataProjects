package com.example.springdatajpa.controller;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeDepartmentController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    Employee employee;

    Employee employee2;

    Page<Employee> employeePage;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        employee = Employee.builder()
                .id(1L)
                .empName("Rani")
                .empEmail("ranisarde@yahoo.com")
                .build();

        employee2 = Employee.builder()
                .id(2L)
                .empName("Jay")
                .empEmail("jay@yahoo.com")
                .build();


        employeePage = new PageImpl<>(List.of(employee, employee2), PageRequest.of(0, 10), 2);
    }


    @Test
    public void testEmployeeWithTheirDeptsTest() throws Exception {

        when(employeeService.employeeWithTheirDepts(employee.getId())).thenReturn(employee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/employeeWithDepts/{empId}", employee.getId());

        ResultActions response = mockMvc.perform(requestBuilder);

        response.andExpect(status().isOk()).andExpect(jsonPath("$.empName",
                is(employee.getEmpName()))).andExpect(jsonPath("$.empEmail",
                is(employee.getEmpEmail())));
    }


    @Test
    public void testDeleteEmployeeWithDepts() throws Exception {
        doNothing().when(employeeService).deleteEmployeeWithDepts(employee.getId());
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/employeeWithDepts/{empId}", employee.getId());

        ResultActions response = mockMvc.perform(requestBuilder);

        response.andExpect(status().isNoContent());
    }

    @Test
    public void testSaveEmployeeWithDepts() throws Exception {
        when(employeeService.saveEmployeeWithDepts(any(Employee.class))).thenReturn(employee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/employeeWithDepts").content(objectMapper.writeValueAsString(employee)).contentType(MediaType.APPLICATION_JSON);

        ResultActions response = mockMvc.perform(requestBuilder);

        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.empName",
                        is(employee.getEmpName())));
    }


    @Test
    public void testWelcome() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/welcome").contentType(MediaType.APPLICATION_JSON);

        ResultActions response = mockMvc.perform(requestBuilder);

        response.andExpect(status().isOk())
                .andExpect(content().string("Welcome to Spring Data JPA Demo"));
    }

    @Test
    public void testAllEmployeesWithTheirDepts() throws Exception {
        when(employeeService.allEmployeesWithTheirDepts()).thenReturn(employeePage);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/employeeWithDepts").contentType(MediaType.APPLICATION_JSON);

        ResultActions response = mockMvc.perform(requestBuilder);

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(2))
                .andExpect(jsonPath("$.content[0].empName").value("Rani"))
                .andExpect(jsonPath("$.content[1].empName").value("Jay"));
    }


}
