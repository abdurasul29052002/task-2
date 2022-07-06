package com.example.task2.controller;

import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.UniversityDTO;
import com.example.task2.service.UniversityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping
    public UniversityDTO addUniversity(@RequestBody @Valid UniversityDTO universityDTO){
        return universityService.save(universityDTO);
    }

    @GetMapping("/{id}")
    public UniversityDTO getUniversity(@PathVariable Long id){
        return universityService.getUniversity(id);
    }

    @GetMapping
    public List<UniversityDTO> getAllUniversities(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "20") Integer size){
        return universityService.findAll(page, size);
    }

    @PutMapping("/{id}")
    public UniversityDTO updateUniversity(@PathVariable Long id, @RequestBody UniversityDTO universityDTO){
        return universityService.update(universityDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteUniversity(@PathVariable Long id){
        return universityService.deleteById(id);
    }

}
