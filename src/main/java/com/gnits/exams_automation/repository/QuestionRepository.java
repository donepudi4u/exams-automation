package com.gnits.exams_automation.repository;

import com.gnits.exams_automation.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestionContainingIgnoreCase(String keyword);
}
