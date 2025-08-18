package com.example.springapp.repository;

import com.example.springapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByDone(boolean done);
}
