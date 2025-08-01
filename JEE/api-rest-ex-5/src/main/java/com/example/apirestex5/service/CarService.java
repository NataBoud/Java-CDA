package com.example.apirestex5.service;


import com.example.apirestex5.model.Car;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.*;

@ApplicationScoped
public class CarService {

    private final Map<UUID, Car> carStore = new HashMap<>();

    // CREATE
    public Car create(Car car) {
        UUID id = UUID.randomUUID();
        car.setId(id);
        carStore.put(id, car);
        return car;
    }

    // READ ALL
    public List<Car> findAll() {
        return new ArrayList<>(carStore.values());
    }

    // READ ONE
    public Car findById(UUID id) {
        return carStore.get(id);
    }

    // UPDATE
    public Car update(UUID id, Car updatedCar) {
        Car existingCar = carStore.get(id);
        if (existingCar != null) {
            updatedCar.setId(id); // Ensure the ID stays the same
            carStore.put(id, updatedCar);
            return updatedCar;
        }
        return null;
    }

    // DELETE
    public boolean delete(UUID id) {
        return carStore.remove(id) != null;
    }

}
