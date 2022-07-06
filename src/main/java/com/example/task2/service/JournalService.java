package com.example.task2.service;

import com.example.task2.entity.Journal;
import com.example.task2.mapper.JournalMapper;
import com.example.task2.payload.JournalDTO;
import com.example.task2.repository.JournalRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

@Service
public class JournalService extends GenericService<Journal, JournalDTO, JournalRepository, JournalMapper> {

    public JournalService(JournalRepository repository, JournalMapper mapper) {
        super(repository, mapper);
    }

    public JournalDTO getJournalById(Long id) {
        Journal journal = findById(id);
        return mapper.entityToModel(journal);
    }
}
