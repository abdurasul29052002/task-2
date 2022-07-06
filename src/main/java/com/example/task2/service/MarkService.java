package com.example.task2.service;

import com.example.task2.entity.Mark;
import com.example.task2.mapper.MarkMapper;
import com.example.task2.payload.MarkDTO;
import com.example.task2.repository.MarkRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

@Service
public class MarkService extends GenericService<Mark, MarkDTO, MarkRepository, MarkMapper> {
    public MarkService(MarkRepository repository, MarkMapper mapper) {
        super(repository, mapper);
    }

    public MarkDTO getMarkById(Long id) {
        Mark mark = findById(id);
        return mapper.entityToModel(mark);
    }
}
