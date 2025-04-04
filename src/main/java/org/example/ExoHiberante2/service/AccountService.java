package org.example.ExoHiberante2.service;

import org.example.ExoHiberante2.entity.Account;
import org.example.ExoHiberante2.entity.Agency;
import org.example.ExoHiberante2.entity.Customer;
import org.example.ExoHiberante2.retository.AccountRepository;
import org.example.ExoHiberante2.utils.exeption.NotFoundException;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public Account createAccount(String libelle, String iban, double balance, List<Customer> customers, Agency agency) {
        Account account = Account.builder()
                .libelle(libelle)
                .iban(iban)
                .balance(balance)
                .customers(customers)
                .agency(agency)
                .build();
        return accountRepository.create(account);
    }

    public Account updateAccount(int id, String libelle, String iban, double balance, List<Customer> customers, Agency agency) {
        Account accountToUpdate = accountRepository.findById(id);

        if (accountToUpdate != null) {
            accountToUpdate.setLibelle(libelle);
            accountToUpdate.setIban(iban);
            accountToUpdate.setBalance(balance);
            accountToUpdate.setCustomers(customers);
            accountToUpdate.setAgency(agency);

            return accountRepository.update(accountToUpdate);
        }

        throw new NotFoundException("Compte avec l'ID " + id + " non trouvé.");
    }

    public Account findById (int id){
        Account account = accountRepository.findById(id);
        if(account != null){
            return account;
        }
        throw new NotFoundException("Client avec l'ID " + id + " non trouvé.");
    }

    public List<Account> findAll (){
        return accountRepository.findAll();
    }

}
