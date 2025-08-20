package com.example.demo_base_rest.service;

import com.example.demo_base_rest.dto.UserReceiveDto;
import com.example.demo_base_rest.dto.UserResponseDto;
import com.example.demo_base_rest.entity.User;
import com.example.demo_base_rest.exception.NotFoundException;
import com.example.demo_base_rest.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {


    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto create(UserReceiveDto userReceiveDto) {
        return userRepository.save(userReceiveDto.dtoToEntity()).entityToDto();
        // userReceiveDto => dtoToEntity => USER mis en BDD => entityToDto => userResponseDto
    }

    public UserResponseDto get(long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<UserResponseDto> get() {
        return userRepository.findAll().stream().map(User::entityToDto).toList();
    }

    public UserResponseDto update(long id, UserReceiveDto userReceiveDto) {
        User userFound = userRepository.findById(id).orElseThrow(NotFoundException::new);
        User userGet = userReceiveDto.dtoToEntity();
        userFound.setName(userGet.getName());
        userFound.setPassword(userGet.getPassword());
        userFound.setBirthDate(userGet.getBirthDate());
        return userRepository.save(userFound).entityToDto();
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    // Pagination
    public Page<User> getPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
