package com.coding.company.repository;


import com.coding.company.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StuentRepository extends JpaRepository<Student, Long> {

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getstudentByEmailId(String emailId);


    //SQL
    @Query(
            value = "select * from student_tbl where email_address = ?1",
            nativeQuery = true
    )
    Student getstudentByEmailIdNative(String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update student_tbl set first_name =?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
