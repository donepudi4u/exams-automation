package com.gnits.exams_automation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "QUESTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question" , nullable = false)
    private String question;

    @Column(name = "question_type" , nullable = false)
    private String questionType; // MCQ / SHORT / LONG

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "complexity_id", nullable = false)
    private Complexity complexity;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy; // faculty user
}
