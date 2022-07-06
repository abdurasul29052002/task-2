package com.example.task2.service;

import com.example.task2.entity.Subject;
import com.example.task2.mapper.SubjectMapper;
import com.example.task2.payload.SubjectDTO;
import com.example.task2.repository.SubjectRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends GenericService<Subject, SubjectDTO, SubjectRepository, SubjectMapper> {
    public SubjectService(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
    }

    public SubjectDTO getSubjectById(Long id) {
        Subject subject = findById(id);
        return mapper.entityToModel(subject);
    }
}
