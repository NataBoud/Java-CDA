package com.example.exercice_02.service;

import com.example.exercice_02.dao.UserRepository;
import com.example.exercice_02.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private HttpSession _HttpSession;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            _HttpSession.setAttribute("username", username);
            _HttpSession.setAttribute("login", "OK");
            return true;
        }
        return false;
    }

    public boolean isLogged(){
        try {
            String isLogged = _HttpSession.getAttribute("login").toString();
            return isLogged.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        _HttpSession.invalidate();
    }

}
