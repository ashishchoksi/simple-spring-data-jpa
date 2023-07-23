package com.example.springboot.repository;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

    /**
     * we can paginate and sort records
     */
    @Test
    public void testGetCoursesWithSortAndPagination() {
        int page = 0;
        int recordPerPage = 2;
        Sort sortByTitleDesc = Sort.by("title").descending();
        PageRequest pageRequest = PageRequest.of(page, recordPerPage, sortByTitleDesc);

        Page<Course> coursePage = courseRepository.findAll(pageRequest);
        System.out.println("Total pages: " + coursePage.getTotalPages());
        System.out.println("Total element: " + coursePage.getTotalElements());
        System.out.println("Find courses : " + coursePage.getContent());

        List<Course> allCourseWithSorting = courseRepository.findAll(sortByTitleDesc);
        System.out.println("course with sort title desc: " + allCourseWithSorting);
    }

    @Test
    public void testGetCoursesWithMultipleSort() {
        int page = 0;
        int recordPerPage = 3;
        Sort sortByTitleDesc = Sort.by("title")
                .and(Sort.by("credit").descending());
        PageRequest pageRequest = PageRequest.of(page, recordPerPage, sortByTitleDesc);

        Page<Course> coursePage = courseRepository.findAll(pageRequest);
        System.out.println("Total pages: " + coursePage.getTotalPages());
        System.out.println("Total element: " + coursePage.getTotalElements());
        System.out.println("Find courses : " + coursePage.getContent());
    }
}