package com.example.postgreSQLDemo.demo.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class StudentRequestDTO {

    private Long id;
    private String name;
    private List<String> emailAddresses;

}
