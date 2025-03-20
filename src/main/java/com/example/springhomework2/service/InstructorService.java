package com.example.springhomework2.service;

import com.example.springhomework2.model.dto.request.InstructorRequest;
import com.example.springhomework2.model.entity.Instructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors();

    Instructor insertInstructor(InstructorRequest instructorRequest);

    Instructor getInstructorById(Integer id);

    Instructor deleteInstructor(Integer id);

    Instructor updateInstructor(Integer id, InstructorRequest instructorRequest);
}
