package com.gnits.exams_automation.mapper;

import com.gnits.exams_automation.dto.AnswerDTO;
import com.gnits.exams_automation.dto.QuestionDTO;
import com.gnits.exams_automation.entity.Complexity;
import com.gnits.exams_automation.entity.Question;
import com.gnits.exams_automation.entity.Subject;
import com.gnits.exams_automation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapper {

    @Autowired
    private UserRepository userRepository;

    public Question toEntity(QuestionDTO dto, Subject subject, Complexity complexity) {
        Question question = new Question();
        question.setId(dto.getId());
        question.setQuestion(dto.getQuestionText());
        question.setQuestionType(dto.getQuestionType());
        question.setSubject(subject);
        question.setComplexity(complexity);
        question.setCreatedBy(userRepository.findById(dto.getCreatedById())
                .orElseThrow(() -> new RuntimeException("User not found")));

        return question;
    }

    public QuestionDTO toDTO(Question entity, List<AnswerDTO> answers) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(entity.getId());
        dto.setQuestionText(entity.getQuestion());
        dto.setQuestionType(entity.getQuestionType());
        dto.setSubjectId(entity.getSubject().getId());
        dto.setComplexityId(entity.getComplexity().getId());
        dto.setCreatedById(entity.getCreatedBy().getId());
        dto.setAnswers(answers);
        return dto;
    }
}
