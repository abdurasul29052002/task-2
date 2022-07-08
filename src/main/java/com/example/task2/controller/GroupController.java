package com.example.task2.controller;

import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.GroupDTO;
import com.example.task2.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public GroupDTO addGroup(@RequestBody GroupDTO groupDTO){
        return groupService.save(groupDTO);
    }

    @GetMapping("/{id}")
    public GroupDTO getGroup(@PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @GetMapping
    public List<GroupDTO> getAllGroups(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size){
        return groupService.findAll(page, size);
    }

    @PutMapping("/{id}")
    public GroupDTO updateGroup(@PathVariable Long id, @RequestBody GroupDTO groupDTO){
        return groupService.update(groupDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteGroup(@PathVariable Long id){
        return groupService.deleteById(id);
    }

    @GetMapping ("/by_faculty_id/{facultyId}")
    public List<GroupDTO> getGroupByFacultyId(@PathVariable Long facultyId){
        return groupService.getGroupsByFacultyId(facultyId);
    }
}
