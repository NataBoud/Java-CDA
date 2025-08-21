package com.example.demo_session_rest.controller;


import com.example.demo_session_rest.model.Cat;
import com.example.demo_session_rest.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cat")
public class CatController {

    private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public Map<Integer,Cat> getCats() {
        return catService.getCatMap();
    }

    @PostMapping
    public void addCat(@RequestBody Cat cat) {
        catService.addCat(cat);
    }
}
