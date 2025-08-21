package com.example.exercice_01.service;

import com.example.exercice_01.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TodoService {
    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoService() {
        this.todos.add(new Todo("test1", "description 1", true));
        this.todos.add(new Todo("test2", "description 2", false));
        this.todos.add(new Todo("test3", "description 3", true));
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodo() {
        return new Todo("todo1", "description 1", true);
    }
}
