package com.example.apirestex5.controller;

import com.example.apirestex5.model.Car;
import com.example.apirestex5.service.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    private CarService carService;

    @Inject
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    // GET /car/all : READ
    @GET
    @Path("/all")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    // GET /car/{id} : récupérer une voiture par son UUID
    @GET
    @Path("/{id}")
    public Response getCarById(@PathParam("id") UUID id) {
        Car car = carService.findById(id);
        if (car != null) {
            return Response.ok(car).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // POST /car : CREATE
    @POST
    public Response createCar(Car car) {
        Car created = carService.create(car);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    // PUT /car/{id} : UPDATE
    @PUT
    @Path("/{id}")
    public Response updateCar(@PathParam("id") UUID id, Car updatedCar) {
        Car updated = carService.update(id, updatedCar);
        if (updated != null) {
            return Response.ok(updated).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // DELETE /car/{id} :
    @DELETE
    @Path("/{id}")
    public Response deleteCar(@PathParam("id") UUID id) {
        boolean deleted = carService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
