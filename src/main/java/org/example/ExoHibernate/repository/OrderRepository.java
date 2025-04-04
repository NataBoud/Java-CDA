package org.example.ExoHibernate.repository;

import org.example.ExoHibernate.Entity.Order.CustomerOrder;
import org.hibernate.Session;

import java.util.List;

public class OrderRepository extends  BaseRepository<CustomerOrder> {
    public OrderRepository() {
        super(CustomerOrder.class);
    }

    public List<CustomerOrder> findByCustomerId(int customerId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM CustomerOrder o WHERE o.customer.id = :customerId", CustomerOrder.class)
                    .setParameter("customerId", customerId)
                    .getResultList();
        }
    }
}
