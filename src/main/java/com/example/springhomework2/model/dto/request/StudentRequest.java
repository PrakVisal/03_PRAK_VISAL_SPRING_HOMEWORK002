package com.example.springhomework2.model.dto.request;

import com.example.springhomework2.model.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String email;
    private String phone;
    private List<Integer> courseId;
}
