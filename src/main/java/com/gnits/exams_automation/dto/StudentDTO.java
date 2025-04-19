package com.gnits.exams_automation.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer id;
    private String name;
    private String email;
    private String mobile;
}
