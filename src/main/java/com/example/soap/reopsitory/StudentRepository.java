package com.example.soap.reopsitory;

import com.example.soap.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mehman on 15-07-2023
 * @project soap
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    Optional<StudentEntity> findByStudentId(Long studentId);
}
