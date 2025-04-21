package com.example.springboot.mongodb.mapper;

import com.example.springboot.mongodb.entity.Student;
import com.example.springboot.mongodb.model.StudentResponse;
import com.example.springboot.mongodb.model.StudentXMLResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentRequestMapper {

    @Mapping(source = "student.name", target = "name")
    @Mapping(source = "student.email", target = "email")
    @Mapping(source = "student.gender", target = "gender")
    @Mapping(source = "student.phNo", target = "phNo")
    StudentResponse getStudentResponse(Student student);


    @Mapping(source = "student.name", target = "name")
    @Mapping(source = "student.email", target = "email")
    @Mapping(source = "student.gender", target = "gender")
    @Mapping(source = "student.phNo", target = "phNo")
    StudentXMLResponseDTO returnStudentResponseInXmlFormat(Student student);



}
