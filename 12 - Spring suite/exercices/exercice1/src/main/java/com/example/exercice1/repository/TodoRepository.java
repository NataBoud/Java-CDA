package com.example.exercice1.repository;

import com.example.exercice1.dto.TodoResponseDto;
import com.example.exercice1.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

  //  public List<Todo> getByIsValidate(boolean status);

    @Query("select t from Todo t where t.isValidate = ?1")
    public List<Todo> getTodoByStatus(boolean status);
}
