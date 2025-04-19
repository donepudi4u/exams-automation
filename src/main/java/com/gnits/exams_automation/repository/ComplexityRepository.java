package com.gnits.exams_automation.repository;

import com.gnits.exams_automation.entity.Complexity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplexityRepository extends JpaRepository<Complexity, Integer> {
    boolean existsByLevel(String level);
}
