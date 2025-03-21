package com.example.springhomework2.repository;

import com.example.springhomework2.model.dto.request.InstructorRequest;
import com.example.springhomework2.model.entity.Instructor;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Select("""
            SELECT * FROM instructors
            """)
    @Results(id = "instructorMapper", value = {
            @Result(property = "id", column = "instructor_id"),
            @Result(property = "name", column = "instructor_name"),
    })
    List<Instructor> getAllInstructors();

    @Select("""
            INSERT INTO instructors(instructor_name, email) 
            VALUES (#{request.name},#{request.email}) RETURNING *
            """)
    @ResultMap("instructorMapper")
    Instructor insertInstructor(@Param("request") InstructorRequest instructorRequest);

    @Select("""
            SELECT * FROM instructors WHERE instructor_id = #{id}
            """)
    @ResultMap("instructorMapper")
    Instructor getInstructorById(Integer id);

    @Select("""
            DELETE FROM instructors WHERE instructor_id = #{id} RETURNING *
            """)
    @ResultMap("instructorMapper")
    Instructor deleteInstructor(Integer id);

    @Select("""
            UPDATE instructors SET instructor_name = #{request.name}, email = #{request.email} WHERE instructor_id = #{id} RETURNING *
            """)
    @ResultMap("instructorMapper")
    Instructor updateInstructor(Integer id, @Param("request") InstructorRequest instructorRequest);
}
