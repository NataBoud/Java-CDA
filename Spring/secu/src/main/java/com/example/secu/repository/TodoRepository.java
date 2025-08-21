package com.example.secu.repository;

import com.example.secu.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("select t from Todo t where t.isValidate = ?1")
    public List<Todo> getTodoByStatus(boolean status);
}
