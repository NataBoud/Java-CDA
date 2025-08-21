package org.example.Service;

import org.example.entity.Account;
import org.example.repository.AccountRepository;
import org.example.repository.BaseRepository;
import org.hibernate.cfg.NotYetImplementedException;

public class AccountService extends BaseService<Account> {

    public AccountService() {
        super(new AccountRepository());
    }

    @Override
    boolean delete(int id) {
        throw new NotYetImplementedException("never be implemented");
    }
}
