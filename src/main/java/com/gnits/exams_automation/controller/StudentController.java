package com.gnits.exams_automation.controller;


import com.gnits.exams_automation.dto.StudentDTO;
import com.gnits.exams_automation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO dto) {
        return studentService.createStudent(dto);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Integer id, @RequestBody StudentDTO dto) {
        return studentService.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
}

