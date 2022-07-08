package com.example.task2.service;

import com.example.task2.entity.Group;
import com.example.task2.mapper.GroupMapper;
import com.example.task2.payload.GroupDTO;
import com.example.task2.repository.GroupRepository;
import com.example.task2.service.template.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService extends GenericService<Group, GroupDTO, GroupRepository, GroupMapper> {
    public GroupService(GroupRepository repository, GroupMapper mapper) {
        super(repository, mapper);
    }
    public GroupDTO getGroupById(Long id) {
        Group group = findById(id);
        return mapper.entityToModel(group);
    }

    public List<GroupDTO> getGroupsByFacultyId(Long facultyId) {
        return mapper.entitiesToModels(repository.findAllByFacultyId(facultyId));
    }
}
