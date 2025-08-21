package com.example.secu.controller;

import com.example.secu.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class AdminController {

    private final TodoService todoService;

    public AdminController(TodoService todoService) {
        this.todoService = todoService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        todoService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello from AdminController");
    }
}
