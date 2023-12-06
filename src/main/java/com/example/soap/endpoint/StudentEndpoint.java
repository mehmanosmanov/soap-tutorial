package com.example.soap.endpoint;

import com.example.soap.dto.*;
import com.example.soap.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Mehman on 15-07-2023
 * @project soap
 */
@Endpoint
@RequiredArgsConstructor
public class StudentEndpoint {

    private final StudentService service;

    private static final String NAMESPACE_URI = "example.com/soap/dto";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "studentRequest")
    @ResponsePayload
    public StudentResponse getStudent(@RequestPayload StudentRequest request) {
        return service.getStudentById(request);
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createStudent")
    @ResponsePayload
    public StudentResponse createStudent(@RequestPayload CreateStudent createStudent) {
      return service.createStudent(createStudent);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "creatStudent")
    @ResponsePayload
    public StudentResponse updateStudent(@RequestPayload CreateStudent createStudent) {
        return service.createStudent(createStudent);
    }

}
