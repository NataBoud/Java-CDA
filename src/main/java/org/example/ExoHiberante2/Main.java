package org.example.ExoHiberante2;

import org.example.ExoHiberante2.controller.AccountController;
import org.example.ExoHiberante2.controller.CustomerController;
import org.example.ExoHiberante2.entity.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("🚀 Démarrage de l'application...");

        CustomerController customerController = new CustomerController();
        AccountController accountController = new AccountController();

        List<Customer> customers = customerController.createFakeCustomers();
        accountController.createFakeAccounts(customers);

        System.out.println("🎉 Données insérées avec succès !");
    }
}
