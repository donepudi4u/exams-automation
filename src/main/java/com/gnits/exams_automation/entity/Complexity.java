package com.gnits.exams_automation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMPLEXITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complexity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String level;
}
