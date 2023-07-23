package com.example.springboot.repository;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void test() {
        Course course = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

        System.out.println("Course save successfully");
    }

}