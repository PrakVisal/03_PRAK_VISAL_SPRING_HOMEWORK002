package com.example.springhomework2.service.impl;

import com.example.springhomework2.model.dto.request.StudentRequest;
import com.example.springhomework2.model.entity.Student;
import com.example.springhomework2.repository.StudentRepository;
import com.example.springhomework2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public Student insertStudent(StudentRequest studentRequest) {
        return studentRepository.insertStudent(studentRequest);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student deleteStudent(Integer id) {
        return studentRepository.deleteStudent(id);
    }
}
