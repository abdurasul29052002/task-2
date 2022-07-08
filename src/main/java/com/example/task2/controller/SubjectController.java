package com.example.task2.controller;

import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.MarkDTO;
import com.example.task2.payload.SubjectDTO;
import com.example.task2.service.MarkService;
import com.example.task2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public SubjectDTO addSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.save(subjectDTO);
    }

    @GetMapping("/{id}")
    public SubjectDTO getMarkSubject(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @GetMapping
    public List<SubjectDTO> getAllSubject(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size){
        return subjectService.findAll(page, size);
    }

    @PutMapping("/{id}")
    public SubjectDTO updateSubject(@PathVariable Long id,@RequestBody SubjectDTO subjectDTO){
        return subjectService.update(subjectDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteSubject(@PathVariable Long id){
        return subjectService.deleteById(id);
    }

    @GetMapping("/by_student_id/{studentId}")
    public List<SubjectDTO> getSubjectsByStudentId(@PathVariable Long studentId){
        return subjectService.getSubjectsByStudentId(studentId);
    }
}
