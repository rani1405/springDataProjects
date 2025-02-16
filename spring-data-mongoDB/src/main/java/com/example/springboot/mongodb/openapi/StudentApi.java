package com.example.springboot.mongodb.openapi;

import com.example.springboot.mongodb.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Tag(name = "Student", description = "Student API")
public interface StudentApi {


    @Operation(summary = "Get a student by its email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the student",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class)) }),
            @ApiResponse(responseCode = "404", description = "Student does not exist",
                    content = @Content) })
    @RequestMapping(method = RequestMethod.GET, value = "/api/get-student-by-email/{email}")
    ResponseEntity<Student> studentByEmail(@PathVariable String email) throws Exception;


    @Operation(summary = "Get all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All students returned",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Student.class)))})})
    @RequestMapping(method = RequestMethod.GET, value = "/api/get-all")
    ResponseEntity<List<Student>> allStudents();


    @Operation(summary = "Save student into DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student saved successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class)) })})
    @RequestMapping(method = RequestMethod.POST, value = "/api/save-student")
    ResponseEntity<Student> saveStudent(@RequestBody Student student);

    @Operation(summary = "Delete student by it's email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student does not exist",
                    content = @Content) })
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/delete-student-by-email/{email}")
    ResponseEntity deleteStudentByEmail(@PathVariable String email);
}
