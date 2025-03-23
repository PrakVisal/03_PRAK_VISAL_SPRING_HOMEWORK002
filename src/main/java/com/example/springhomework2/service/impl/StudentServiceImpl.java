package com.example.springhomework2.service.impl;

import com.example.springhomework2.model.dto.request.StudentRequest;
import com.example.springhomework2.model.entity.Student;
import com.example.springhomework2.repository.CourseRepository;
import com.example.springhomework2.repository.StudentRepository;
import com.example.springhomework2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> getAllStudent(Integer page, Integer pageSize) {
        return studentRepository.getAllStudent(page, pageSize);
    }

    @Override
    public Student insertStudent(StudentRequest studentRequest) {
        Student student = studentRepository.insertStudent(studentRequest);
        for(Integer courseId : studentRequest.getCourseId()){
            courseRepository.insertStudentIdAndCourseId(student.getId(), courseId);
        }
        return studentRepository.getStudentById(student.getId());
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student deleteStudent(Integer id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public Student updateStudent(Integer id, StudentRequest studentRequest) {
        Student student = studentRepository.updateStudent(id, studentRequest);
        courseRepository.deleteStudentCourseByStudentId(student.getId());
        for(Integer courseId : studentRequest.getCourseId()){
            courseRepository.insertStudentIdAndCourseId(student.getId(), courseId);
        }
        return studentRepository.updateStudent(student.getId(), studentRequest);
    }
}
