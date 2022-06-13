package com.coding.company.repository;

import com.coding.company.entity.Course;
import com.coding.company.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher() {

        Course courseBoot = Course.builder()
                .CourseName("Spring Boot")
                .credit(5)
                .build();
        Course courseDBA = Course.builder()
                .CourseName("DBA")
                .credit(6)
                .build();


        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Lennon")
                //.courses(List.of(courseBoot,courseDBA))
                .build();
        repository.save(teacher);
}
}