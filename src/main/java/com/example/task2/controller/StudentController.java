package com.example.task2.controller;

import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.MarkDTO;
import com.example.task2.payload.StudentDTO;
import com.example.task2.service.MarkService;
import com.example.task2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDTO addMark(@RequestBody StudentDTO studentDTO){
        return studentService.save(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getMark(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentDTO> getAllMarks(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size){
        return studentService.findAll(page, size);
    }

    @PutMapping("/{id}")
    public StudentDTO updateMark(@PathVariable Long id,@RequestBody StudentDTO studentDTO){
        return studentService.update(studentDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteMark(@PathVariable Long id){
        return studentService.deleteById(id);
    }

    @GetMapping("/find")
    public List<StudentDTO> searchStudents(@RequestParam(value = "search") String targetWord){
        return studentService.searchStudents(targetWord);
    }

    @GetMapping("/by_group_id")
    public List<StudentDTO> getStudentsByGroupId(@RequestParam Long groupId){
        return studentService.getStudentsByGroupId(groupId);
    }

}
