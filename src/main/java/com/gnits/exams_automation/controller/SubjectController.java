package com.gnits.exams_automation.controller;

import com.gnits.exams_automation.dto.SubjectDTO;
import com.gnits.exams_automation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin("*")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO dto) {
        return subjectService.createSubject(dto);
    }

    @PutMapping("/{id}")
    public SubjectDTO updateSubject(@PathVariable Integer id, @RequestBody SubjectDTO dto) {
        return subjectService.updateSubject(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
    }

    @GetMapping("/{id}")
    public SubjectDTO getSubject(@PathVariable Integer id) {
        return subjectService.getSubject(id);
    }

    @GetMapping
    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
