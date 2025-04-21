package com.example.springboot.mongodb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@XmlRootElement(name = "Student")
public class StudentXMLResponseDTO {

    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "student_name")
    private String name;
    private String email;
    private String gender;
    @JsonIgnore
    private Integer phNo;
}
