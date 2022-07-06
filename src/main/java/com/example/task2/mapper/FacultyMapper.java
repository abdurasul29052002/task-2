package com.example.task2.mapper;

import com.example.task2.entity.Faculty;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.FacultyDTO;
import com.example.task2.payload.UniversityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UniversityMapper.class})
public interface FacultyMapper extends GenericMapper<Faculty, FacultyDTO> {

}
