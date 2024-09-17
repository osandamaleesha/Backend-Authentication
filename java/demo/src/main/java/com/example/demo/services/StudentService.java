package com.example.demo.services;

import com.example.demo.dto.StudentDTO;
import com.example.demo.requests.StudentRequest;

import java.util.UUID;

public interface StudentService {
    StudentDTO getStudentById(UUID id);
    StudentDTO createStudent(StudentRequest studentRequest); // Update to accept StudentRequest
    StudentDTO updateStudent(StudentRequest studentRequest); // Update to accept StudentRequest
    void deleteStudent(UUID id);
}
