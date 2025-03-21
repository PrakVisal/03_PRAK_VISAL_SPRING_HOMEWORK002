package com.example.springhomework2.service;

import com.example.springhomework2.model.dto.request.StudentRequest;
import com.example.springhomework2.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(Integer page, Integer pageSize);

    Student insertStudent(StudentRequest studentRequest);

    Student getStudentById(Integer id);

    Student deleteStudent(Integer id);
}
