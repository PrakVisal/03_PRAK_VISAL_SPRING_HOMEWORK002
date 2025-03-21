package com.example.springhomework2.repository;

import com.example.springhomework2.model.dto.request.StudentRequest;
import com.example.springhomework2.model.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
            SELECT * FROM students
            """)
    @Results(id = "studentMapper", value = {
            @Result(property = "id", column = "student_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "phone", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "com.example.springhomework2.repository.CourseRepository.getAllCourseByStudentId"))
    })
    List<Student> getAllStudent();

    @Select("""
            INSERT INTO students(student_name, email,phone_number) 
            VALUES (#{request.name}, #{request.email}, #{request.phone}) RETURNING *
            """)
    @ResultMap("studentMapper")
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
