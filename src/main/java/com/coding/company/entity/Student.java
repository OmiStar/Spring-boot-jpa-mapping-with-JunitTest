package com.coding.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "student_tbl",
        uniqueConstraints =@UniqueConstraint(
                name ="emilid_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    private Long StudentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            unique = true,
            nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;

}
