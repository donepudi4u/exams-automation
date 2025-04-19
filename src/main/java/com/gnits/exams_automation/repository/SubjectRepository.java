package com.gnits.exams_automation.repository;

import com.gnits.exams_automation.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    boolean existsByName(String name);
}
