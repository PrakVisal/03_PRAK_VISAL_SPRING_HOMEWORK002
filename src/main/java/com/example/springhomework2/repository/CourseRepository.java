package com.example.springhomework2.repository;

import com.example.springhomework2.model.dto.request.CourseRequest;
import com.example.springhomework2.model.entity.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("""
            SELECT * FROM courses
            """)
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", many = @Many(select = "com.example.springhomework2.repository.InstructorRepository.getInstructorById"))
    })
    List<Course> getAllCourse();

    @Select("""
            INSERT INTO courses(course_name,description,instructor_id) 
            VALUES (#{request.name},#{request.description},#{request.instructorId}) RETURNING *
            """)
    @ResultMap("courseMapper")
    @Result(property = "instructorId", column = "instructor_id")
    Course insertCourse(@Param("request") CourseRequest courseRequest);

    @Select("""
            SELECT * FROM courses WHERE course_id = #{id}
            """)
    @ResultMap("courseMapper")
    Course getCourseById(Integer id);

    @Select("""
            DELETE FROM courses WHERE course_id = #{id} RETURNING *
            """)
    @ResultMap("courseMapper")
    Course deleteCourse(Integer id);

    @Select("""
            UPDATE courses
            SET course_name = #{request.name}, description = #{request.description}, instructor_id = #{request.instructorId} WHERE course_id = #{id} RETURNING *
            """)
    @ResultMap("courseMapper")
    @Result(property = "instructorId", column = "instructor_id")
    Course updateCourse(Integer id, @Param("request") CourseRequest courseRequest);

    @Select("""
            SELECT sc.course_id ,course_name, description, instructor_id FROM student_course sc inner join public.courses c
                on c.course_id = sc.course_id  WHERE student_id = #{studentId} ;
            """)
    @ResultMap("courseMapper")
    List<Course> getAllCourseByStudentId(Integer studentId);

    @Insert("""
            INSERT INTO student_course(student_id,course_id) VALUES (#{studentId},#{courseId})
            """)
    void insertStudentIdAndCourseId(Integer studentId, Integer courseId);
}
