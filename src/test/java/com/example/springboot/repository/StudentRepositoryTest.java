package com.example.springboot.repository;

import com.example.springboot.entity.Guardian;
import com.example.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void testStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("chirag")
                .email("chirag@mail.com")
                .mobile("1234567809")
                .build();

        Student student = Student.builder()
                .firstname("ashish")
                .lastName("choksi")
                .emailId("ash@info.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void testFindByFirstName() {
        List<Student> students = studentRepository.findByFirstname("ashish");
        System.out.println("Find by first name : " + students);
    }

    @Test
    public void testFindByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstnameContaining("as");
        System.out.println("Find by first name with pattern: " + students);
    }

    @Test
    public void testFindStudentWithGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("piyush");
        System.out.println("Find by guardian name " + students);
    }

    @Test
    public void testFindStudentByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Find by last name not null: " + students);
    }

    @Test
    public void testGetStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("ash@info.com");
        System.out.println("find by email: " + student);
    }

    @Test
    public void testGetFirstnameByEmailId() {
        String student = studentRepository.getFirstNameByEmailId("ash@info.com");
        System.out.println("find by email: " + student);
    }

    @Test
    public void testGetStudentByEmailNativeQuery() {
        Student student = studentRepository.getStudentByEmailIdNative("ash@info.com");
        System.out.println("Student by email native: " + student);
    }

    private Student createStudent() {
        return Student.builder()
                .firstname("ashish")
                .lastName("choksi")
                .emailId("ashish@gmail.com")
//                .guardianName("piyush")
//                .guardianEmail("piyush@gmail.com")
//                .guardianMobile("1232467897")
                .build();
    }

}