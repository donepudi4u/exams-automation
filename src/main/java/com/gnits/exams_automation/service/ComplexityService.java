package com.gnits.exams_automation.service;

import com.gnits.exams_automation.dto.ComplexityDTO;
import com.gnits.exams_automation.mapper.ComplexityMapper;
import com.gnits.exams_automation.entity.Complexity;
import com.gnits.exams_automation.repository.ComplexityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplexityService {

    @Autowired
    private ComplexityRepository complexityRepository;

    @Autowired
    private ComplexityMapper mapper;

    public ComplexityDTO createComplexity(ComplexityDTO dto) {
        if (dto.getLevel()!= null && complexityRepository.existsByLevel(dto.getLevel())) {
            throw new RuntimeException("Level already exists");
        }
        return mapper.toDTO(complexityRepository.save(mapper.toEntity(dto)));
    }

    public List<ComplexityDTO> getAllLevels() {
        return complexityRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
