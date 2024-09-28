//package com.example.demo.controllers;
//
//import com.example.demo.dto.StudentDTO;
//import com.example.demo.requests.StudentRequest;
//import com.example.demo.services.StudentService;
//import com.example.demo.validation.StudentNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/students")
//@Validated
//public class StudentController {
//
//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<StudentDTO> getStudentById(@PathVariable UUID id) {
//        StudentDTO studentDTO = studentService.getStudentById(id);
//        return ResponseEntity.ok(studentDTO);
//    }
//
//    @PostMapping
//    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
//        StudentDTO studentDTO = studentService.createStudent(studentRequest);
//        return ResponseEntity.status(HttpStatus.CREATED).body(studentDTO);
//    }
//
//    @PutMapping
//    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentRequest studentRequest) {
//        StudentDTO studentDTO = studentService.updateStudent(studentRequest);
//        return ResponseEntity.ok(studentDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.noContent().build();
//    }
//}
