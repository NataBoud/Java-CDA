package com.example.demo_bases.controller;

import com.example.demo_bases.model.Person;
import com.example.demo_bases.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
    // Injection de dépendance
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(helloService.sayHello());
        return "home";
    }

    @RequestMapping("/json")
    // Conversion automatique de la valeur de retour en format JSON
    @ResponseBody
    public List<String> getPersons(){
        new Person(1, "Toto", "Tata");
        return List.of("Toto", "Tata", "Titi");
    }

    @RequestMapping("/person")
    public String person(Model model){
        model.addAttribute("firstName", "Toto");
        model.addAttribute("lastName", "Tata");
        List<String> persons = List.of("Toto", "Tata", "Titi");

        model.addAttribute("persons", persons);

        return "person/details";
    }
}
