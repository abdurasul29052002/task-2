package com.example.task2.mapper;

import com.example.task2.entity.University;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.UniversityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversityMapper extends GenericMapper<University, UniversityDTO> {

}
