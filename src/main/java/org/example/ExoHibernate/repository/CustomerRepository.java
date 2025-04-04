package org.example.ExoHibernate.repository;

import org.example.ExoHibernate.Entity.Customer.Customer;

public class CustomerRepository extends BaseRepository<Customer> {
    public CustomerRepository() {
        super(Customer.class);
    }
}
