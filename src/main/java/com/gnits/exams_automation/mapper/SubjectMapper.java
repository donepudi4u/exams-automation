package com.gnits.exams_automation.mapper;

import com.gnits.exams_automation.dto.SubjectDTO;
import com.gnits.exams_automation.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public Subject toEntity(SubjectDTO dto) {
        return new Subject(dto.getId(), dto.getName(),dto.getDescription());
    }

    public SubjectDTO toDTO(Subject entity) {
        return new SubjectDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
}
