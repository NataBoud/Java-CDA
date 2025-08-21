package com.example.demo_jpa.dao;

import com.example.demo_jpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByNomAndPrenom(String name, String prenom);
}
