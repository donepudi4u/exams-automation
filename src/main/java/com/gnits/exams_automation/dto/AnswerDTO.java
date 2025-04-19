package com.gnits.exams_automation.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private Long id;
    private String optionText;
    private boolean correct;
}
