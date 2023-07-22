package com.example.springboot.repository;

import com.example.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstname(String firstName);

    List<Student> findByFirstnameContaining(String firstName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);
}
