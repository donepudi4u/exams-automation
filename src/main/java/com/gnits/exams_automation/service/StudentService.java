package com.gnits.exams_automation.service;


import com.gnits.exams_automation.entity.Student;
import com.gnits.exams_automation.mapper.StudentMapper;
import com.gnits.exams_automation.dto.StudentDTO;
import com.gnits.exams_automation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentDTO createStudent(StudentDTO dto) {
        if (dto.getId() != null && (studentRepository.existsById(dto.getId()) || studentRepository.existsByEmail(dto.getEmail()))) {
            throw new RuntimeException("Student already exists");
        }
        Student student = studentMapper.toEntity(dto);
        return studentMapper.toDTO(studentRepository.save(student));
    }

    public StudentDTO updateStudent(Integer id, StudentDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return studentMapper.toDTO(studentRepository.save(student));
    }

    public void deleteStudent(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    public StudentDTO getStudent(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }
}

