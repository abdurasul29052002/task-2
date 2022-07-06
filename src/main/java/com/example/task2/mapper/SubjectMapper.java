package com.example.task2.mapper;

import com.example.task2.entity.Subject;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.SubjectDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GroupMapper.class})
public interface SubjectMapper extends GenericMapper<Subject, SubjectDTO> {
}
