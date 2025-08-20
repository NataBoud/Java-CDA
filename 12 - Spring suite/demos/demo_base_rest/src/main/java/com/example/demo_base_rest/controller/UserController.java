package com.example.demo_base_rest.controller;


import com.example.demo_base_rest.dto.UserReceiveDto;
import com.example.demo_base_rest.dto.UserResponseDto;
import com.example.demo_base_rest.entity.User;
import com.example.demo_base_rest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public User getUser(){
//        User user = new User();
//        user.setId(1);
//        user.setName("toto");
//        user.setPassword("toto");
//        user.setBirthDate(LocalDate.now());
//        return user;
//    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAl() {
        return ResponseEntity.ok(userService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getOne(@PathVariable long id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserReceiveDto userReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable long id, @RequestBody UserReceiveDto userReceiveDto) {
        return ResponseEntity.ok(userService.update(id, userReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok(String.format("Delete user with id %d", id));
    }

    // Recuperer tous les users avec pagination
    @GetMapping("/paged")
   // public Page<User> getPage(@RequestParam(required = false) int page, @RequestParam int size) {}
    public Page<User> getPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return userService.getPage(PageRequest.of(page, size));
    }
}
