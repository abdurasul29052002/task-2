package com.example.task2.service;

import com.example.task2.entity.Faculty;
import com.example.task2.mapper.FacultyMapper;
import com.example.task2.payload.FacultyDTO;
import com.example.task2.repository.FacultyRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

@Service
public class FacultyService extends GenericService<Faculty, FacultyDTO, FacultyRepository, FacultyMapper> {
    public FacultyService(FacultyRepository repository, FacultyMapper mapper) {
        super(repository, mapper);
    }
    public FacultyDTO getFaculty(Long id) {
        Faculty faculty = findById(id);
        return mapper.entityToModel(faculty);
    }
}
