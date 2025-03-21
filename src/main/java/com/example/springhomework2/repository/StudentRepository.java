package com.example.springhomework2.repository;

import com.example.springhomework2.model.dto.request.StudentRequest;
import com.example.springhomework2.model.entity.Student;
import lombok.Builder;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
            SELECT * FROM students OFFSET #{pageSize}*(#{page}-1) LIMIT #{pageSize}
            """)
    @Results(id = "studentMapper", value = {
            @Result(property = "id", column = "student_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "phone", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "com.example.springhomework2.repository.CourseRepository.getAllCourseByStudentId"))
    })
    List<Student> getAllStudent(Integer page,Integer pageSize);

    @Select("""
            INSERT INTO students(student_name,email,phone_number)
            VALUES (#{request.name}, #{request.email}, #{request.phone}) RETURNING *
            """)
    @ResultMap("studentMapper")
    @Result(property = "courseId", column = "course_id", many =  @Many(select = "com.example.springhomework2.repository.CourseRepository.getCourseById"))
    Student insertStudent(@Param("request") StudentRequest studentRequest);

    @Select("""
            SELECT * FROM students where student_id = #{id} 
            """)
    @ResultMap("studentMapper")
    Student getStudentById(Integer id);

    @Select("""
            DELETE FROM students where student_id = #{id} RETURNING *
            """)
    @ResultMap("studentMapper")
    Student deleteStudent(Integer id);
}
