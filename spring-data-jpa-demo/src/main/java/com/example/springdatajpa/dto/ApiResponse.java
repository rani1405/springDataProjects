package com.example.springdatajpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T>{

    T response;

    private int count;

}
