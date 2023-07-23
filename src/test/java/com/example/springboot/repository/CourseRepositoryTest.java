package com.example.springboot.repository;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("all courses: " + courses);
    }

    @Test
    public void testCourseSaveWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("ravi")
                .lastName("gulati")
                .build();

        Course course = Course.builder()
                .title("RDBMS")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}