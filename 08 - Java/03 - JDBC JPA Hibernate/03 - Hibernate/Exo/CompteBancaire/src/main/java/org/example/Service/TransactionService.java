package org.example.Service;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Transaction;
import org.example.repository.BaseRepository;
import org.example.repository.TransactionRepository;
import org.hibernate.cfg.NotYetImplementedException;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionService extends BaseService<Transaction> {

    public TransactionService() {
        super(new TransactionRepository());
    }

    @Override
    public Transaction create(Transaction element) {
        element.getReceiverAccount().setBalance(element.getReceiverAccount().getBalance()+ element.getAmount());
        element.getSenderAccount().setBalance(element.getSenderAccount().getBalance()- element.getAmount());
        element.setDate(LocalDateTime.now());

        return super.create(element);
    }

    @Override
    public Transaction update(Transaction element) {
        throw new NotYetImplementedException("update Transaction never be implemented");
    }

    @Override
    boolean delete(int id) {
        throw new NotYetImplementedException("update Transaction never be implemented");
    }

    public List<Transaction> getReiceveTransaction (int id){
        if(repository instanceof TransactionRepository transactionRepository){
            return  transactionRepository.getReceiveTransaction(id);
        }
        return null;
    }

    public List<Transaction> getSendTransaction (int id){
        if(repository instanceof TransactionRepository transactionRepository){
            return  transactionRepository.getSendTransaction(id);
        }
        return null;
    }
}
