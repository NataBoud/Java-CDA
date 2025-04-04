package org.example.ExoHiberante2.controller;

import org.example.ExoHiberante2.entity.Customer;
import org.example.ExoHiberante2.service.CustomerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public List<org.example.ExoHiberante2.entity.Customer> createFakeCustomers() {
        List<Customer> customers = new ArrayList<>();

        customers.add(customerService.createCustomer("Alice", "Durand", LocalDate.of(1990, 5, 12), new ArrayList<>()));
        customers.add(customerService.createCustomer("Bob", "Martin", LocalDate.of(1985, 7, 24), new ArrayList<>()));
        customers.add(customerService.createCustomer("Charlie", "Lemoine", LocalDate.of(2000, 1, 15), new ArrayList<>()));

        System.out.println("✅ Clients ajoutés avec succès !");
        return customers;
    }

}
