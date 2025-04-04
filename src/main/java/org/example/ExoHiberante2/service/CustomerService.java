package org.example.ExoHiberante2.service;

import org.example.ExoHiberante2.entity.Account;
import org.example.ExoHiberante2.entity.Customer;
import org.example.ExoHiberante2.retository.CustomerRepository;
import org.example.ExoHiberante2.utils.exeption.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public Customer createCustomer(String firstName, String lastName, LocalDate birthDate,  List<Account> accounts) {
        Customer customer = Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .accounts(accounts)
                .build();
        return customerRepository.create(customer);
    }

    public Customer updateCustomer(String firstName, String lastName, LocalDate birthDate, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(customer.getId());
        if (customerToUpdate != null) {
            customerToUpdate.setFirstName(firstName);
            customerToUpdate.setLastName(lastName);
            customerToUpdate.setBirthDate(birthDate);
            return customerRepository.update(customerToUpdate);
        }
        throw new NotFoundException("Client avec l'ID " + customer.getId() + " non trouvé.");
    }

    public boolean delete (int id){
        Customer customer = customerRepository.findById(id);
        if(customer != null){
            return customerRepository.delete(customer);
        }
        return false;
    }

    public Customer findById (int id){
        Customer customer = customerRepository.findById(id);
        if(customer != null){
            return customer;
        }
        throw new NotFoundException("Client avec l'ID " + id + " non trouvé.");
    }

    public List<Customer> findAll (){
        return customerRepository.findAll();
    }
}
