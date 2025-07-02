package com.preworkgenericmethods.services;

import com.preworkgenericmethods.dto.StudentDTO;
import com.preworkgenericmethods.models.Student;
import com.preworkgenericmethods.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends GenericServiceImpl<Student, Long, StudentDTO> implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

    @Override
    public void handleRelations(Student entity, StudentDTO studentDTO) {
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class; // Düzeltildi
    }

}
