package org.example.repository;

import org.example.entity.Account;
import org.example.entity.Agency;
import org.example.entity.Customer;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository extends BaseRepository<Account> {
    @Override
    public Account findById(int id) {
        session = sessionFactory.openSession();
        Account account = session.get(Account.class,id);
        session.close();
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = null;
        session = sessionFactory.openSession();
        Query<Account> accountQuery = session.createQuery("from Account ",Account.class);
        accounts = accountQuery.list();
        session.close();
        return accounts;
    }
}
