package com.gnits.exams_automation.service;

import com.gnits.exams_automation.dto.SubjectDTO;
import com.gnits.exams_automation.mapper.SubjectMapper;
import com.gnits.exams_automation.entity.Subject;
import com.gnits.exams_automation.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    public SubjectDTO createSubject(SubjectDTO dto) {
        if (dto.getId() != null && (subjectRepository.existsById(dto.getId()) || subjectRepository.existsByName(dto.getName()))) {
            throw new RuntimeException("Subject already exists");
        }
        return subjectMapper.toDTO(subjectRepository.save(subjectMapper.toEntity(dto)));
    }

    public SubjectDTO updateSubject(Integer id, SubjectDTO dto) {
        Subject existing = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        existing.setName(dto.getName());
        return subjectMapper.toDTO(subjectRepository.save(existing));
    }

    public void deleteSubject(Integer id) {
        if (!subjectRepository.existsById(id)) {
            throw new RuntimeException("Subject not found");
        }
        subjectRepository.deleteById(id);
    }

    public SubjectDTO getSubject(Integer id) {
        return subjectMapper.toDTO(subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found")));
    }

    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toDTO)
                .collect(Collectors.toList());
    }
}
