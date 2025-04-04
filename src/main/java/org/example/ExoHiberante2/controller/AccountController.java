package org.example.ExoHiberante2.controller;

import org.example.ExoHiberante2.entity.Agency;
import org.example.ExoHiberante2.entity.Customer;
import org.example.ExoHiberante2.retository.AgencyRepository;
import org.example.ExoHiberante2.service.AccountService;

import java.util.List;

public class AccountController  {
    private final AccountService accountService;
    private AgencyRepository agencyRepository;

    public AccountController() {
        this.accountService = new AccountService();
    }

    public void createFakeAccounts(List<Customer> customers) {
        Agency agency = Agency.builder()
                .name("Agence Paris 1")
                .build();
        agency = agencyRepository.create(agency);

        accountService.createAccount("Compte Courant", "FR761234567890", 5000.0, customers, agency);
        accountService.createAccount("Livret A", "FR761234567891", 2000.0, customers, agency);
        accountService.createAccount("Compte Épargne", "FR761234567892", 10000.0, customers, agency);

        System.out.println("✅ Comptes bancaires ajoutés avec succès !");
    }
}
