package org.example.repository;

import org.example.entity.Agency;
import org.example.entity.Customer;
import org.example.entity.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionRepository extends BaseRepository<Transaction> {
    @Override
    public Transaction findById(int id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.get(Transaction.class,id);
        session.close();
        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = null;
        session = sessionFactory.openSession();
        Query<Transaction> customerQuery = session.createQuery("from Transaction ",Transaction.class);
        transactions = customerQuery.list();
        session.close();
        return transactions;
    }

    public List<Transaction> getReceiveTransaction (int id){
        List<Transaction> transactions = null;
        session = sessionFactory.openSession();
        Query<Transaction> transactionQuery = session.createQuery("Select t from Transaction t WHERE t.receiverAccount = :id ",Transaction.class);
        transactionQuery.setParameter("id",id);
        transactions = transactionQuery.list();
        session.close();
        return transactions;
    }

    public List<Transaction> getSendTransaction (int id){
        List<Transaction> transactions = null;
        session = sessionFactory.openSession();
        Query<Transaction> transactionQuery = session.createQuery("Select t from Transaction t WHERE t.senderAccount = :id ",Transaction.class);
        transactionQuery.setParameter("id",id);
        transactions = transactionQuery.list();
        session.close();
        return transactions;
    }
}
