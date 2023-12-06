package com.example.soap.entity;

import com.example.soap.dto.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Mehman on 15-07-2023
 * @project soap
 */
@Entity
@Setter
@Getter
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String firstName;
    private String lastname;
    private int age;
    private Gender gender;
}
