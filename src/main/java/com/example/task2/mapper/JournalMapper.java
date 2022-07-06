package com.example.task2.mapper;

import com.example.task2.entity.Journal;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.JournalDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GroupMapper.class, SubjectMapper.class})
public interface JournalMapper extends GenericMapper<Journal, JournalDTO> {
}
