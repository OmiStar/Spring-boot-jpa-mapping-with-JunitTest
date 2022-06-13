package com.coding.company.repository;

import com.coding.company.entity.Guardian;
import com.coding.company.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StuentRepositoryTest {

    @Autowired
    private StuentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .firstName("cool")
                .lastName("Coder")
                .emailId("coolcoder@gmail.com")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }


@Test
    public void savewithGuardian() {

    Guardian gurdian = Guardian.builder()
            .name("Nikhil")
            .email("N@gmail.com")
            .mobile("9999994589")
            .build();

    Student student = Student.builder()
            .firstName("shiva")
            .lastName("readdy")
            .emailId("siva@gmail.com")
            .guardian(gurdian)
            .build();

    studentRepository.save(student);

}


    @Test
    public void findAllStudent(){
        List<Student> studentsList =
                studentRepository.findAll();
        System.out.println(studentsList);
    }

    @Test
    public void printgetStduentByEmailAddress(){
    Student student=
         studentRepository.getstudentByEmailId("siva@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStduentByEmailAddressNative(){
        Student student=
                studentRepository.getstudentByEmailIdNative(
                        "coolcoder@gmail.com"
                );
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId(
                "shivam",
                "siva@gmail.com"
        );
    }


}