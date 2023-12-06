package com.example.soap.service;

import com.example.soap.dto.CreateStudent;
import com.example.soap.dto.Student;
import com.example.soap.dto.StudentRequest;
import com.example.soap.dto.StudentResponse;
import com.example.soap.entity.StudentEntity;
import com.example.soap.mapper.StudentMapper;
import com.example.soap.reopsitory.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mehman on 15-07-2023
 * @project soap
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Override
    public StudentResponse createStudent(CreateStudent request) {
        StudentEntity student = mapper.dtoToEntity(request);
        return mapper.entityToDto(studentRepository.save(student));
    }

    @Override
    public StudentResponse getStudentById(StudentRequest request) {
        Optional<StudentEntity> entity = Optional.of(studentRepository.findByStudentId(request.getStudentId())).orElseThrow(
                () -> new NoSuchElementException("Not found student with such id=".concat(String.valueOf(request.getStudentId()))));
        return entity.map(mapper::entityToDto).orElse(null);
    }

    @Override
    public List<StudentResponse> getStudents() {
        return studentRepository.findAll().stream().
                map(mapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void update(StudentRequest request) {

    }

    @Override
    public void delete(StudentRequest request) {

    }
}
