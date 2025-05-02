package com.example.postgreSQLDemo.demo.dto;

import com.example.postgreSQLDemo.demo.entity.Address;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class StudentResponseDTO {

    private Long studentId;
    private String studentName;
    private List<String> studentEmailAddresses;
    private List<Address> addressList;

}
