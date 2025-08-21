package com.example.demo_jpa.controller;

import com.example.demo_jpa.dao.PersonRepository;
import com.example.demo_jpa.model.Person;
import com.example.demo_jpa.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("personne", new Person());
        return "form";
    }

    @PostMapping("/add")
    public String add(Person person) {
        personService.save(person);
        return "redirect:/";
    }
}
