package com.example.exercice3.service;

import com.example.exercice3.model.Cat;

import java.util.List;

public interface IServiceCat {

    List<Cat> getAll();
    void addCat(Cat cat);
}
