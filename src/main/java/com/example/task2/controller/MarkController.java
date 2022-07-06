package com.example.task2.controller;

import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.MarkDTO;
import com.example.task2.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping
    public MarkDTO addMark(@RequestBody MarkDTO markDTO){
        return markService.save(markDTO);
    }

    @GetMapping("/{id}")
    public MarkDTO getMark(@PathVariable Long id){
        return markService.getMarkById(id);
    }

    @GetMapping
    public List<MarkDTO> getAllMarks(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size){
        return markService.findAll(page, size);
    }

    @PutMapping("/{id}")
    public MarkDTO updateMark(@PathVariable Long id,@RequestBody MarkDTO markDTO){
        return markService.update(markDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteMark(@PathVariable Long id){
        return markService.deleteById(id);
    }
}
