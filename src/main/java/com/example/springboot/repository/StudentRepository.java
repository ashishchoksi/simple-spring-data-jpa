package com.example.springboot.repository;

import com.example.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstname(String firstName);

    List<Student> findByFirstnameContaining(String firstName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    // JPQL query syntax not JPA pre-define method here you should refer class & variable name not table & column
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstname from Student s where s.emailId = ?1")
    String getFirstNameByEmailId(String emailId);

    // Native query
    @Query(
            value = "select * from tbl_student where email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);

    // Native query with named param
    @Query(
            value = "select * from tbl_student where email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeWithNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set firstname = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
