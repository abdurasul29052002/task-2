package com.example.task2.service;

import com.example.task2.entity.Student;
import com.example.task2.mapper.StudentMapper;
import com.example.task2.payload.MarkDTO;
import com.example.task2.payload.StudentDTO;
import com.example.task2.repository.StudentRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends GenericService<Student, StudentDTO, StudentRepository, StudentMapper> {
    public StudentService(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
    }

    public StudentDTO getStudentById(Long id) {
        Student student = findById(id);
        return mapper.entityToModel(student);
    }
}
