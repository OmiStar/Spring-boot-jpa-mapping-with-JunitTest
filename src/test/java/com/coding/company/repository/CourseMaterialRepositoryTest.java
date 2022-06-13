package com.coding.company.repository;

import com.coding.company.entity.Course;
import com.coding.company.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest  {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course=
                Course.builder()
                .CourseName("Java")
                .credit(3)
                .build();


        CourseMaterial courseMaterial=CourseMaterial.builder()
                .courseUrl("www.udemy.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void findAllCourseMaterial(){

        List<CourseMaterial> courseMaterialList =
                courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }


}