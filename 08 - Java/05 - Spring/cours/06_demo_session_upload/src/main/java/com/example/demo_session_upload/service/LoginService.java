package com.example.demo_session_upload.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private String login = "admin";
    private String password = "admin123";

    @Autowired
    HttpSession session;

    public boolean login(String username, String password) {
        if (username.equals(this.login) && password.equals(this.password)) {
            session.setAttribute("login", "OK");
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        session.invalidate();
    }

    public boolean checkLogin() {
        try {
            String isOk = session.getAttribute("login").toString();
            return isOk.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }
}
