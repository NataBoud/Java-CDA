package org.example.Service;

import org.example.entity.Customer;
import org.example.repository.BaseRepository;
import org.example.repository.CustomerRepository;

import java.util.List;

public class CustomerService extends BaseService<Customer> {
    public CustomerService() {
        super(new CustomerRepository());
    }
}
