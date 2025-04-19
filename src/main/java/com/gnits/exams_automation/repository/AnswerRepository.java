package com.gnits.exams_automation.repository;

import com.gnits.exams_automation.entity.Answer;
import com.gnits.exams_automation.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
