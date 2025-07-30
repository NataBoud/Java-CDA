package com.example.exercice3.service;

import com.example.exercice3.model.Cat;

import java.util.ArrayList;
import java.util.List;

/*

Version sans BDD
 */


public class ServiceCatList implements IServiceCat{

    private List<Cat> catList;

    public ServiceCatList() {
        catList = new ArrayList<Cat>();
    }

    @Override
    public List<Cat> getAll() {
        return catList;
    }

    @Override
    public void addCat(Cat cat) {
        catList.add(cat);
    }
}
