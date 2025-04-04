package org.example.ExoHiberante2.retository;

import org.example.ExoHiberante2.entity.Account;
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
        List<Account> accountList = null;
        session = sessionFactory.openSession();
        Query<Account> accountQuery = session.createQuery("from Account ",Account.class);
        accountList = accountQuery.list();
        session.close();
        return accountList;
    }
}
