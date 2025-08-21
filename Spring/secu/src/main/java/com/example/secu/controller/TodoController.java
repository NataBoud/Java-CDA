package com.example.secu.controller;

import com.example.secu.dto.todo.TodoReceiveDto;
import com.example.secu.dto.todo.TodoResponseDto;
import com.example.secu.exception.NotFoundException;
import com.example.secu.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/todo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAl() {
        return ResponseEntity.ok(todoService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getOne(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(todoService.get(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(@RequestBody TodoReceiveDto todoReceiveDto) {
        return ResponseEntity.ok(todoService.create(todoReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable int id, @RequestBody TodoReceiveDto todoReceiveDto) throws NotFoundException {
        return ResponseEntity.ok(todoService.update(id, todoReceiveDto));
    }

    @PatchMapping("/change/{id}")
    public ResponseEntity<TodoResponseDto> changeStatus(@PathVariable int id) throws NotFoundException {
        return  ResponseEntity.ok(todoService.changeStatus(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TodoResponseDto>> getAll(@PathVariable String status) {
        return ResponseEntity.ok(todoService.getByStatus(Boolean.parseBoolean(status)));
    }
}
