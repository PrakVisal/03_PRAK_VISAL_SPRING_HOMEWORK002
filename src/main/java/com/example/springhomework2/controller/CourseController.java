package com.example.springhomework2.controller;

import com.example.springhomework2.model.dto.request.CourseRequest;
import com.example.springhomework2.model.dto.response.ApiResponse;
import com.example.springhomework2.model.entity.Course;
import com.example.springhomework2.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping()
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .success(true)
                .message("Get all courses successfully")
                .status(HttpStatus.OK)
                .payload(courseService.getAllCourses())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> insertCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .message("Inserted course successfully")
                .status(HttpStatus.OK)
                .payload(courseService.insertCourse(courseRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable Integer id) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .message("Get course by id successfully")
                .status(HttpStatus.OK)
                .payload(courseService.getCourseById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable Integer id) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .message("Deleted course successfully")
                .status(HttpStatus.OK)
                .payload(courseService.deleteCourse(id))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Integer id, @RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .message("Updated course successfully")
                .status(HttpStatus.OK)
                .payload(courseService.updateCourse(id,courseRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
