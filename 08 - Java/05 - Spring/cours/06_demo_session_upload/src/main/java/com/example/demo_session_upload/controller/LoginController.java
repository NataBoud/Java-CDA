package com.example.demo_session_upload.controller;

import com.example.demo_session_upload.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login")
    public String login() {
        return "form";
    }

    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (loginService.login(username, password)) {
            return "protected";
        } else
            return "redirect:/login";
    }

    @RequestMapping("/protected")
    public String protectedPage() {
        if (loginService.checkLogin()){
            return "protected";
        }
        return "redirect:/login";
    }
}
