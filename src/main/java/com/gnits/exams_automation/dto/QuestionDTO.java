package com.gnits.exams_automation.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String questionText;
    private String questionType;
    private Integer subjectId;
    private Integer complexityId;
    private List<AnswerDTO> answers; // only for MCQ
    private Integer createdById;
}
