package com.example.task2.service;

import com.example.task2.entity.Student;
import com.example.task2.mapper.StudentMapper;
import com.example.task2.payload.StudentDTO;
import com.example.task2.repository.StudentRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class StudentService extends GenericService<Student, StudentDTO, StudentRepository, StudentMapper> {
    public StudentService(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
    }

    public StudentDTO getStudentById(Long id) {
        Student student = findById(id);
        return mapper.entityToModel(student);
    }

    public List<StudentDTO> searchStudents(String targetWord) {
        return mapper.entitiesToModels(repository.findAllByNameIsLikeIgnoreCase("%"+targetWord+"%"));
    }

    public List<StudentDTO> getStudentsByGroupId(Long groupId) {
        List<Student> students = repository.findAllByGroupId(groupId);
        return mapper.entitiesToModels(students);
    }
}
