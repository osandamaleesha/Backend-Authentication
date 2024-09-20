package com.example.demo.services;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.requests.StudentRequest;
import com.example.demo.validation.StudentNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    @Cacheable(value = "students", key = "#id")
    public StudentDTO getStudentById(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        return studentMapper.toDTO(student);
    }

    @Override
    @CachePut(value = "students", key = "#studentRequest.id")
    public StudentDTO createStudent(StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);
        student.setId(UUID.randomUUID()); // Generate new UUID for creation
        studentRepository.save(student);
        return studentMapper.toDTO(student);
    }

    @Override
    @CachePut(value = "students", key = "#studentRequest.id")
    public StudentDTO updateStudent(StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentRequest.getId())
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        student.setGrade(studentRequest.getGrade());
        student.setMajor(studentRequest.getMajor());
        studentRepository.save(student);
        return studentMapper.toDTO(student);
    }

    @Override
    @CacheEvict(value = "students", key = "#id")
    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }
}
