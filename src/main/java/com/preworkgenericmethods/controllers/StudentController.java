package com.preworkgenericmethods.controllers;

import com.preworkgenericmethods.dto.StudentDTO;
import com.preworkgenericmethods.models.Student;
import com.preworkgenericmethods.services.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController extends GenericController<Student, Long, StudentDTO> {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super(studentService, Student.class, StudentDTO.class);
        this.studentService = studentService;
    }
}