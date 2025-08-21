package com.example.exercice1.controller;


import com.example.exercice1.dto.TodoReceiveDto;
import com.example.exercice1.dto.TodoResponseDto;
import com.example.exercice1.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAl() {
        return ResponseEntity.ok(todoService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getOne(@PathVariable int id) {
        return ResponseEntity.ok(todoService.get(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(@RequestBody TodoReceiveDto todoReceiveDto) {
        return ResponseEntity.ok(todoService.create(todoReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable int id, @RequestBody TodoReceiveDto todoReceiveDto) {
            return ResponseEntity.ok(todoService.update(id, todoReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
            todoService.delete(id);
            return ResponseEntity.ok("Deleted");
    }

    @PatchMapping("/change/{id}")
    public ResponseEntity<TodoResponseDto> changeStatus(@PathVariable int id) {
        return  ResponseEntity.ok(todoService.changeStatus(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TodoResponseDto>> getAll(@PathVariable String status) {
        return ResponseEntity.ok(todoService.getByStatus(Boolean.parseBoolean(status)));
    }
}
