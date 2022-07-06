package com.example.task2.mapper;

import com.example.task2.entity.Student;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GroupMapper.class})
public interface StudentMapper extends GenericMapper<Student, StudentDTO> {
}
