package com.example.springhomework2.controller;

import com.example.springhomework2.model.dto.request.InstructorRequest;
import com.example.springhomework2.model.dto.response.ApiResponse;
import com.example.springhomework2.model.entity.Instructor;
import com.example.springhomework2.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Operation(summary = "Get all Instructors")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .success(true)
                .message("Get all instructors successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.getAllInstructors())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Add a Instructors")
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> insetInstructor(@RequestBody InstructorRequest instructorRequest) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .message("Inserted Successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.insertInstructor(instructorRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Get Instructor by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable Integer id) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .message("Get Instructor by Id Success")
                .status(HttpStatus.OK)
                .payload(instructorService.getInstructorById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Delete a Instructor")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructor(@PathVariable Integer id) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .message("Deleted Successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.deleteInstructor(id))
                .timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Update a Instructor")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable Integer id, @RequestBody InstructorRequest instructorRequest) {
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .message("Updated successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.updateInstructor(id, instructorRequest))
                .timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
