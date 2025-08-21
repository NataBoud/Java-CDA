package com.example.secu.controller;

import com.example.secu.dto.LoginRequestDto;
import com.example.secu.dto.LoginResponseDto;
import com.example.secu.dto.RegisterRequestDto;
import com.example.secu.dto.RegisterResponseDto;
import com.example.secu.entity.UserApp;
import com.example.secu.exception.NotFoundException;
import com.example.secu.exception.UserAlreadyExistException;
import com.example.secu.security.JWTGenerator;
import com.example.secu.service.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserAppController {
    private final AuthenticationManager authenticationManager;

    private final UserAppService userAppService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public UserAppController(AuthenticationManager authenticationManager, UserAppService userAppService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }


    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDTO) throws NotFoundException {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(LoginResponseDto.builder().token(generator.generateToken(authentication)).build());
        }catch (Exception ex) {
            throw new NotFoundException();
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDTO) throws UserAlreadyExistException {
        registerRequestDTO.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        UserApp userApp = userAppService.enregistrerUtilisateur(registerRequestDTO);
        return ResponseEntity.ok(RegisterResponseDto.builder()
                .id(userApp.getId_user())
                .email(userApp.getEmail())
                .lastName(userApp.getLastName()).firstName(userApp.getFirstName())
                .phone(userApp.getPhone())
                .role(userApp.getRole().ordinal()).build());
    }
}
