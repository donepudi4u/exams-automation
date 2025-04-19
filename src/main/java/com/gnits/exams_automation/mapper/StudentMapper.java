package com.gnits.exams_automation.mapper;


import com.gnits.exams_automation.entity.Student;
import com.gnits.exams_automation.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentDTO dto) {
        return new Student(dto.getId(), dto.getName(), dto.getEmail(),dto.getMobile());
    }

    public StudentDTO toDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getMobile());
    }
}
