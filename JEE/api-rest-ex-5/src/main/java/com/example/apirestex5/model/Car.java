package com.example.apirestex5.model;

import java.util.UUID;

public class Car {
    private UUID id;
    private Brand brand;
    private int yearOfManufacture;
    private String color;

    public Car() {
        // si id non fourni
        this.id = UUID.randomUUID();
    }

    public Car(UUID id, Brand brand, int yearOfManufacture, String color) {
        this.id = id;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

