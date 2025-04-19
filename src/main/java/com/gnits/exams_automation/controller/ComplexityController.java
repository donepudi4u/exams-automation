package com.gnits.exams_automation.controller;

import com.gnits.exams_automation.dto.ComplexityDTO;
import com.gnits.exams_automation.service.ComplexityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complexity")
@CrossOrigin("*")
public class ComplexityController {

    @Autowired
    private ComplexityService complexityService;

    @PostMapping
    public ComplexityDTO createComplexity(@RequestBody ComplexityDTO dto) {
        return complexityService.createComplexity(dto);
    }

    @GetMapping
    public List<ComplexityDTO> getAllComplexities() {
        return complexityService.getAllLevels();
    }
}
