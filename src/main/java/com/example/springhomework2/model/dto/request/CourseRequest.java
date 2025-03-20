package com.example.springhomework2.model.dto.request;

import com.example.springhomework2.model.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {
    private String name;
    private String description;
    private Integer instructorId;
}
