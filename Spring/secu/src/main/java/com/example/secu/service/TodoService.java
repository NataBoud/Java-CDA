package com.example.secu.service;

import com.example.secu.dto.todo.TodoReceiveDto;
import com.example.secu.dto.todo.TodoResponseDto;
import com.example.secu.entity.Todo;
import com.example.secu.exception.NotFoundException;
import com.example.secu.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto create(TodoReceiveDto todoReceiveDto) {
        return todoRepository.save(todoReceiveDto.dtoToEntity()).entityToDto();
    }

    public TodoResponseDto get(int id) throws NotFoundException {
        return todoRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<TodoResponseDto> get() {
        return todoRepository.findAll().stream()
                .map(Todo::entityToDto)
                .toList();
    }

    public TodoResponseDto update(int id, TodoReceiveDto todoReceiveDto) throws NotFoundException {
        Todo todoFound = todoRepository.findById(id).orElseThrow(NotFoundException::new);
        Todo todoGet = todoReceiveDto.dtoToEntity();
        todoFound.setTitle(todoGet.getTitle());
        todoFound.setDescription(todoGet.getDescription());
        todoFound.setDate(todoGet.getDate());
        todoFound.setValidate(todoGet.isValidate());
        return todoRepository.save(todoFound).entityToDto();

    }

    public TodoResponseDto changeStatus(int id) throws NotFoundException {
        Todo todoFound = todoRepository.findById(id).orElseThrow(NotFoundException::new);
        todoFound.setValidate(!todoFound.isValidate());
        return todoRepository.save(todoFound).entityToDto();

    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }

    public List<TodoResponseDto> getByStatus(boolean status) {
        return todoRepository.getTodoByStatus(status).stream().map(Todo::entityToDto).toList();
    }
}
