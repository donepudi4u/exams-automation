package com.gnits.exams_automation.service;

import com.gnits.exams_automation.dto.AnswerDTO;
import com.gnits.exams_automation.dto.QuestionDTO;
import com.gnits.exams_automation.entity.Answer;
import com.gnits.exams_automation.entity.Complexity;
import com.gnits.exams_automation.entity.Question;
import com.gnits.exams_automation.entity.Subject;
import com.gnits.exams_automation.mapper.QuestionMapper;
import com.gnits.exams_automation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ComplexityRepository complexityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionMapper questionMapper;

    public QuestionDTO addQuestion(QuestionDTO dto) {
        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Invalid Subject"));
        Complexity complexity = complexityRepository.findById(dto.getComplexityId())
                .orElseThrow(() -> new RuntimeException("Invalid Complexity"));

        Question question = questionMapper.toEntity(dto, subject, complexity);
        question = questionRepository.save(question);

        Question finalQuestion = question;
        List<Answer> answers = dto.getAnswers() != null
                ? dto.getAnswers().stream()
                .map(ans -> new Answer(null, ans.getOptionText(), ans.isCorrect(), finalQuestion))
                .collect(Collectors.toList())
                : List.of();

        answerRepository.saveAll(answers);

        List<AnswerDTO> savedAnswers = answers.stream()
                .map(a -> new AnswerDTO(a.getId(), a.getAnswer(), a.isCorrect()))
                .collect(Collectors.toList());

        return questionMapper.toDTO(question, savedAnswers);
    }

    public List<QuestionDTO> searchSimilarQuestions(String keyword) {
        return questionRepository.findByQuestionContainingIgnoreCase(keyword)
                .stream()
                .map(q -> {
                    List<AnswerDTO> answers = answerRepository.findByQuestion(q).stream()
                            .map(a -> new AnswerDTO(a.getId(), a.getAnswer(), a.isCorrect()))
                            .collect(Collectors.toList());
                    return questionMapper.toDTO(q, answers);
                })
                .collect(Collectors.toList());
    }
}
