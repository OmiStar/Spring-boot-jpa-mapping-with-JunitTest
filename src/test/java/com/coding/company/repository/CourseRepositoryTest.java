package com.coding.company.repository;

import com.coding.company.entity.Course;
import com.coding.company.entity.Student;
import com.coding.company.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        courseRepository.findAll().forEach(System.out::println);
    }
    @Test
    public void saveCourseWithTeacher(){
        Course course = Course.
                builder()
                .CourseName("python")
                .credit(6)
                .teacher(Teacher.builder()
                        .firstName("priyanka")
                        .lastName("Singh")
                        .build())
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=
        Teacher.builder()
                .firstName("Lizzy")
                .lastName("Morgen")
                .build();

        Student student= Student
                .builder()
                .firstName("Aman")
                .lastName("Kumar")
                .emailId("AmanK@gmail.com")
                .build();

        Course course= Course
                .builder()
                .CourseName("AI")
                .credit(10)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}