package com.example.postgreSQLDemo.demo.mapper;

import com.example.postgreSQLDemo.demo.dto.StudentResponseDTO;
import com.example.postgreSQLDemo.demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "student.name", target = "studentName")
    @Mapping(source = "student.emailAddress", target = "studentEmailAddresses")
    @Mapping(source = "student.address", target = "address")
    StudentResponseDTO saveStudentResponse(Student student);


    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "student.name", target = "studentName")
    @Mapping(source = "student.emailAddress", target = "studentEmailAddresses")
    @Mapping(source = "student.address", target = "address")
    StudentResponseDTO getStudentResponse(Student student);



}
