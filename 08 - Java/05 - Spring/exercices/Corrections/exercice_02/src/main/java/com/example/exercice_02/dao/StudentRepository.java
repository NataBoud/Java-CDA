package com.example.exercice_02.dao;

import com.example.exercice_02.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByLastname(String name);
}
