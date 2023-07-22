package com.example.springboot.repository;

import com.example.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // this is use for integration test not recommended for JPA test because it impacts DB
// @DataJpaTest // standard way to test repository
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = createStudent();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("All students : "  + students);
    }

    private Student createStudent() {
        return Student.builder()
                .firstname("ashish")
                .lastName("choksi")
                .emailId("ashish@gmail.com")
                .guardianName("piyush")
                .guardianEmail("piyush@gmail.com")
                .guardianMobile("1232467897")
                .build();
    }

}