package com.example.task2.controller;

import com.example.task2.entity.Journal;
import com.example.task2.payload.ApiResponse;
import com.example.task2.payload.JournalDTO;
import com.example.task2.service.JournalService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping
    public JournalDTO addJournal(@RequestBody JournalDTO journalDTO) {
        return journalService.save(journalDTO);
    }

    @GetMapping("/{id}")
    public JournalDTO getJournal(@PathVariable Long id) {
        return journalService.getJournalById(id);
    }

    @GetMapping
    public List<JournalDTO> getAllJournals(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size) {
        return journalService.findAll(page, size);
    }

    @PutMapping("/{id}")
    public JournalDTO updateJournal(@PathVariable Long id, @RequestBody JournalDTO journalDTO){
        return journalService.update(journalDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteJournal(@PathVariable Long id){
        return  journalService.deleteById(id);
    }
}
