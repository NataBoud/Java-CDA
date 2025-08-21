package com.example.secu.service;

import com.example.secu.dto.RegisterRequestDto;
import com.example.secu.entity.UserApp;
import com.example.secu.exception.UserAlreadyExistException;
import com.example.secu.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService {

    private final UserAppRepository userAppRepository;
    public UserAppService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    public UserApp enregistrerUtilisateur(RegisterRequestDto registerRequestDto) throws UserAlreadyExistException {
        Optional<UserApp> userAppOptional = userAppRepository.findByEmail(registerRequestDto.getEmail());
        // public UserApp(String firstName, String lastName, String email, String phone, String password, int role)
        if(userAppOptional.isEmpty()){
            // L'email n'est pas deja presente en bdd j'enregistre ce nouvel user
            UserApp userApp = new UserApp(registerRequestDto.getFirstName(),
                    registerRequestDto.getLastName(),
                    registerRequestDto.getEmail(),
                    registerRequestDto.getPhone(),
                    registerRequestDto.getPassword(),
                    registerRequestDto.getRole());
            return userAppRepository.save(userApp);
        }
        // email present en bdd je ne peux enregistrer ce nouvel utilisateur
        throw new UserAlreadyExistException();
    }
}

