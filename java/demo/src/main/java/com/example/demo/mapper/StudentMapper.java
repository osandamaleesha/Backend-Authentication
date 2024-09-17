package com.example.demo.mapper;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.requests.StudentRequest;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setGrade(student.getGrade());
        dto.setMajor(student.getMajor());
        return dto;
    }

    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setGrade(studentDTO.getGrade());
        student.setMajor(studentDTO.getMajor());
        return student;
    }

    public Student toEntity(StudentRequest studentRequest) {
        Student student = new Student();
        student.setGrade(studentRequest.getGrade());
        student.setMajor(studentRequest.getMajor());
        return student;
    }
}
