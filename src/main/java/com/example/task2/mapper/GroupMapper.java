package com.example.task2.mapper;

import com.example.task2.entity.Group;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.GroupDTO;
import org.mapstruct.Mapper;

import javax.persistence.MappedSuperclass;

@Mapper(componentModel = "spring", uses = {FacultyMapper.class})
public interface GroupMapper extends GenericMapper<Group, GroupDTO> {
}
