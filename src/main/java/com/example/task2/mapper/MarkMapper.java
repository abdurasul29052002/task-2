package com.example.task2.mapper;

import com.example.task2.entity.Mark;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.MarkDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, JournalMapper.class})
public interface MarkMapper extends GenericMapper<Mark, MarkDTO> {
}
