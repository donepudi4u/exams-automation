package com.gnits.exams_automation.controller;

import com.gnits.exams_automation.dto.QuestionDTO;
import com.gnits.exams_automation.service.QuestionService;
import com.gnits.exams_automation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @PostMapping
    public QuestionDTO addQuestion(@RequestBody QuestionDTO dto) {
        return questionService.addQuestion(dto);
    }

    @GetMapping("/search")
    public List<QuestionDTO> searchSimilarQuestions(@RequestParam("q") String query) {
        return questionService.searchSimilarQuestions(query);
    }
}
