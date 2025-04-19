package com.gnits.exams_automation.dto;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String role;
    private String email;
    private String password;
}
