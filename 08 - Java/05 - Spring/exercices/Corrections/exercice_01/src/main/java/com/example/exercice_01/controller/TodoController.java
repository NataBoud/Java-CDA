package com.example.exercice_01.controller;

import com.example.exercice_01.model.Todo;
import com.example.exercice_01.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/todos")
    @ResponseBody
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @RequestMapping("/todo")
    public String getOneTodo(Model model){
        model.addAttribute("todo", todoService.getTodo());
        return "todo";
    }
}
