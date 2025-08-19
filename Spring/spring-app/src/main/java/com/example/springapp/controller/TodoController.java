package com.example.springapp.controller;

import com.example.springapp.dto.TodoReceiveDto;
import com.example.springapp.dto.TodoResponseDto;
import com.example.springapp.entity.Todo;
import com.example.springapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAllTodos() {
        return ResponseEntity.ok(todoService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getOne(@PathVariable long id) {
        return ResponseEntity.ok(todoService.get(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(@RequestBody TodoReceiveDto todoReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todoReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable long id, @RequestBody TodoReceiveDto todoReceiveDto) {
        return ResponseEntity.ok(todoService.update(id, todoReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        todoService.delete(id);
        return ResponseEntity.ok(String.format("Delete todo with id %d", id));
    }

    // GET /api/todo/status?done=true
    @GetMapping("/status")
    public ResponseEntity<List<TodoResponseDto>> getByDone(@RequestParam boolean done) {
        return ResponseEntity.ok(todoService.getByDone(done));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TodoResponseDto> changeStatus(@PathVariable long id) {
        return ResponseEntity.ok(todoService.changeStatus(id));
    }

}
