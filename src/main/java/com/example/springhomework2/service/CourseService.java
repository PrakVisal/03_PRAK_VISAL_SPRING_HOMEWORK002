package com.example.springhomework2.service;

import com.example.springhomework2.model.dto.request.CourseRequest;
import com.example.springhomework2.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course insertCourse(CourseRequest courseRequest);

    Course getCourseById(Integer id);

    Course deleteCourse(Integer id);

    Course updateCourse(Integer id, CourseRequest courseRequest);
}
