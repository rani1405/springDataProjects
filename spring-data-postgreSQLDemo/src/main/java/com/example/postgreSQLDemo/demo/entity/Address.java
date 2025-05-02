package com.example.postgreSQLDemo.demo.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Address {

    private long streetNumber;

    private String streetName;

    private String postalCode;

}
