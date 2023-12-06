package com.example.soap.mapper;

import com.example.soap.dto.CreateStudent;
import com.example.soap.dto.StudentResponse;
import com.example.soap.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.net.CacheRequest;

/**
 * @author Mehman on 15-07-2023
 * @project soap
 */

@Mapper(componentModel = "spring")
public interface StudentMapper {


    @Mapping(target = "student.firstName", source = "firstName")
    @Mapping(target = "student.lastname", source = "lastname")
    @Mapping(target = "student.age", source = "age")
    @Mapping(target = "student.studentId", source = "studentId")
    @Mapping(target = "student.gender", source = "gender")
    StudentResponse entityToDto(StudentEntity entity);

    @Mapping(target = "firstName", source = "student.firstName")
    @Mapping(target = "lastname", source = "student.lastname")
    @Mapping(target = "age", source = "student.age")
    @Mapping(target = "studentId", source = "student.studentId")
    @Mapping(target = "gender", source = "student.gender")
    StudentEntity dtoToEntity(CreateStudent createStudent);


}
