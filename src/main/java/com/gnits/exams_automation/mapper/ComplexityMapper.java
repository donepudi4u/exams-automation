package com.gnits.exams_automation.mapper;

import com.gnits.exams_automation.dto.ComplexityDTO;
import com.gnits.exams_automation.entity.Complexity;
import org.springframework.stereotype.Component;

@Component
public class ComplexityMapper {

    public Complexity toEntity(ComplexityDTO dto) {
        return new Complexity(dto.getId(), dto.getLevel());
    }

    public ComplexityDTO toDTO(Complexity entity) {
        return new ComplexityDTO(entity.getId(), entity.getLevel());
    }
}
