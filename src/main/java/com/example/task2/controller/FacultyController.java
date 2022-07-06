package com.example.task2.controller;

import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.FacultyDTO;
import com.example.task2.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public FacultyDTO addFaculty(@RequestBody FacultyDTO facultyDTO){
        return facultyService.save(facultyDTO);
    }

    @GetMapping
    public List<FacultyDTO> getAllFaculties(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size){
        return facultyService.findAll(page,size);
    }

    @GetMapping("/{id}")
    public FacultyDTO getFaculty(@PathVariable Long id){
        return facultyService.getFaculty(id);
    }

    @PutMapping("/{id}")
    public FacultyDTO updateFaculty(@RequestBody FacultyDTO facultyDTO, @PathVariable Long id){
        return facultyService.update(facultyDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteFaculty(@PathVariable Long id){
        return facultyService.deleteById(id);
    }
}
