package com.example.springhomework2.service.impl;

import com.example.springhomework2.model.dto.request.CourseRequest;
import com.example.springhomework2.model.entity.Course;
import com.example.springhomework2.repository.CourseRepository;
import com.example.springhomework2.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Course insertCourse(CourseRequest courseRequest) {
        return courseRepository.insertCourse(courseRequest);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course deleteCourse(Integer id) {
        return courseRepository.deleteCourse(id);
    }

    @Override
    public Course updateCourse(Integer id, CourseRequest courseRequest) {
        return courseRepository.updateCourse(id,courseRequest);
    }
}
