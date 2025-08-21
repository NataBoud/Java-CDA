package org.example;

import org.example.Service.AccountService;
import org.example.Service.AgencyService;
import org.example.Service.CustomerService;
import org.example.Service.TransactionService;
import org.example.entity.Account;
import org.example.entity.Agency;
import org.example.entity.Customer;
import org.example.entity.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService= new CustomerService();
        AccountService accountService = new AccountService();
        AgencyService agencyService = new AgencyService();
        TransactionService transactionService = new TransactionService();

//        Customer customer = Customer.builder().firstName("toto").lastName("tata").birthDate(LocalDate.now()).build();
//        Customer customer2 = Customer.builder().firstName("titi").lastName("tutu").birthDate(LocalDate.now()).build();
//
//        Agency agency = Agency.builder().adress("th eadress of the agency").build();
//
//        Account account1 = Account.builder().agency(agency).balance(1200f).iban("14863188651354").libelle("fr45468741").customers(Arrays.asList(customer)).build();
//        Account account2 = Account.builder().agency(agency).balance(1200f).iban("14863188651354").libelle("fr45468741").customers(Arrays.asList(customer)).build();
//        Account account3 = Account.builder().agency(agency).balance(1200f).iban("14863188651354").libelle("fr45468741").customers(Arrays.asList(customer)).build();


//        customerService.create(customer);
//        customerService.create(customer2);
//
//        agencyService.create(agency);
//
//        accountService.create(account1);
//        accountService.create(account2);
//        accountService.create(account3);

//        Account accountReceive = accountService.findById(3);
//        Account accountSender = accountService.findById(1);
//
//        Transaction transaction = Transaction.builder().amount(200).receiverAccount(accountReceive).senderAccount(accountSender).build();
//
//        transactionService.create(transaction);

        System.out.println(customerService.findById(1));
        System.out.println(transactionService.getSendTransaction(1));
        System.out.println(transactionService.getReiceveTransaction(3));
    }
}