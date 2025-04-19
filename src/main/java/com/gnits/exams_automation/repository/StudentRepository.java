package com.gnits.exams_automation.repository;


import com.gnits.exams_automation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsByEmail(String email);
}
