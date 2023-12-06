package com.example.soap.service;

import com.example.soap.dto.CreateStudent;
import com.example.soap.dto.StudentRequest;
import com.example.soap.dto.StudentResponse;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

/**
 * @author Mehman on 15-07-2023
 * @project soap
 */
public interface StudentService {


    StudentResponse createStudent(CreateStudent request);

    StudentResponse getStudentById(StudentRequest request);

    List<StudentResponse> getStudents();

    void update(StudentRequest request);

    void delete(StudentRequest request);
}
