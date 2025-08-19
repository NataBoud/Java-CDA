package com.example.springapp.service;

import com.example.springapp.dto.TodoReceiveDto;
import com.example.springapp.dto.TodoResponseDto;
import com.example.springapp.entity.Todo;
import com.example.springapp.exception.NotFoundException;
import com.example.springapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // CREATE
    public TodoResponseDto create(TodoReceiveDto todoReceiveDto) {
        return todoRepository.save(todoReceiveDto.dtoToEntity()).entityToDto();
    }

    // READ ONE
    public TodoResponseDto get(long id) {
        return todoRepository.findById(id)
                .orElseThrow(NotFoundException::new)
                .entityToDto();
    }

    // READ ALL
    public List<TodoResponseDto> get() {
        return todoRepository.findAll()
                .stream()
                .map(Todo::entityToDto)
                .toList();
    }

    // UPDATE
    public TodoResponseDto update(long id, TodoReceiveDto todoReceiveDto) {
        Todo todoFound = todoRepository.findById(id).orElseThrow(NotFoundException::new);

        Todo todoGet = todoReceiveDto.dtoToEntity();

        todoFound.setTitle(todoGet.getTitle());
        todoFound.setDescription(todoGet.getDescription());
        todoFound.setDate(todoGet.getDate());
        todoFound.setDone(todoGet.isDone());

        return todoRepository.save(todoFound).entityToDto();
    }

    // DELETE
    public void delete(long id) {
        todoRepository.deleteById(id);
    }

    public TodoResponseDto changeStatus(long id) {
        Todo todoFound = todoRepository.findById(id).orElseThrow(NotFoundException::new);
        todoFound.setDone(!todoFound.isDone());
        return todoRepository.save(todoFound).entityToDto();
    }

    // GET VALIDATED TODOS
    public List<TodoResponseDto> getByDone(boolean done) {
        return todoRepository.findByDone(done)
                .stream()
                .map(Todo::entityToDto)
                .toList();
    }

}
