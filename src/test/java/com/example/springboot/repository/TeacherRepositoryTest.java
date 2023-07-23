package com.example.springboot.repository;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseOS = Course.builder()
                .title("OS")
                .credit(4)
                .build();
        Course courseDBMS = Course.builder()
                .title("DBMS")
                .credit(7)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("amit")
                .lastName("mankodi")
                .courses(List.of(courseOS, courseDBMS))
                .build();

        teacherRepository.save(teacher);
        System.out.println("save successfully...");
    }
}