package com.example.task2.service;

import com.example.task2.entity.University;
import com.example.task2.mapper.UniversityMapper;
import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.UniversityDTO;
import com.example.task2.repository.UniversityRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService extends GenericService<University, UniversityDTO, UniversityRepository, UniversityMapper> {

    public UniversityService(UniversityRepository repository, UniversityMapper mapper) {
        super(repository, mapper);
    }
    public UniversityDTO getUniversity(Long id) {
        University university = findById(id);
        return mapper.entityToModel(university);
    }
}
