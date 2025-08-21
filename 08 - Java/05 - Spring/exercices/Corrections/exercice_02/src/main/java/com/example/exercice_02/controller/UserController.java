package com.example.exercice_02.controller;

import com.example.exercice_02.model.User;
import com.example.exercice_02.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("mode", "login");
        return "authForm";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("mode", "register");
        return "authForm";
    }

    @PostMapping("/validate")
    public String validate(@RequestParam(name = "mode") String mode, @ModelAttribute("user") User user){
        if(mode.equals("login")){
            userService.login(user.getUsername(), user.getPassword());
        } else {
            userService.register(user);
        }
        return "redirect:/login";
    }
    @RequestMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
