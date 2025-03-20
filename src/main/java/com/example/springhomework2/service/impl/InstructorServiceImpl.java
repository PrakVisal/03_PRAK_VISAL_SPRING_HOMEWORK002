package com.example.springhomework2.service.impl;

import com.example.springhomework2.model.dto.request.InstructorRequest;
import com.example.springhomework2.model.entity.Instructor;
import com.example.springhomework2.repository.InstructorRepository;
import com.example.springhomework2.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository instructorRepository;
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.getAllInstructors();
    }

    @Override
    public Instructor insertInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.insertInstructor(instructorRequest);
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor deleteInstructor(Integer id) {
        return instructorRepository.deleteInstructor(id);
    }

    @Override
    public Instructor updateInstructor(Integer id, InstructorRequest instructorRequest) {
        return instructorRepository.updateInstructor(id,instructorRequest);
    }
}
