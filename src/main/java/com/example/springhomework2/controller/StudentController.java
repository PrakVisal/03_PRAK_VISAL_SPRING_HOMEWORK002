package com.example.springhomework2.controller;

import com.example.springhomework2.model.dto.request.StudentRequest;
import com.example.springhomework2.model.dto.response.ApiResponse;
import com.example.springhomework2.model.entity.Student;
import com.example.springhomework2.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get all Students")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent() {
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .success(true)
                .message("Get all Students Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.getAllStudent())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Add a Student still developing...")
    @PostMapping
    public Student insertStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.insertStudent(studentRequest);
    }

    @Operation(summary = "Get Student by ID")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @Operation(summary = "Delete Student by ID")
    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }

    @Operation(summary = "Update a Student still developing...")
    @PutMapping
    public Student updateStudent(@RequestBody StudentRequest studentRequest) {
        return null;
    }
}
