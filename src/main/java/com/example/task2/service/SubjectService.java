package com.example.task2.service;

import com.example.task2.entity.Student;
import com.example.task2.entity.Subject;
import com.example.task2.exception.NotFoundException;
import com.example.task2.mapper.SubjectMapper;
import com.example.task2.payload.SubjectDTO;
import com.example.task2.repository.StudentRepository;
import com.example.task2.repository.SubjectRepository;
import com.example.task2.service.template.GenericService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SubjectService extends GenericService<Subject, SubjectDTO, SubjectRepository, SubjectMapper> {

    @Autowired
    StudentRepository studentRepository;
    public SubjectService(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
    }

    public SubjectDTO getSubjectById(Long id) {
        Subject subject = findById(id);
        return mapper.entityToModel(subject);
    }

    @SneakyThrows
    public List<SubjectDTO> getSubjectsByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundException::new);
        List<Subject> subjectList = repository.findAllByGroup_StudentsId(studentId);
        return mapper.entitiesToModels(subjectList);
    }
}
