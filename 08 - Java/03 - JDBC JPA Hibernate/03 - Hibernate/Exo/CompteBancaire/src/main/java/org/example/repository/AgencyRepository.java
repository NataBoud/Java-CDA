package org.example.repository;

import org.example.entity.Agency;
import org.example.entity.Customer;
import org.hibernate.query.Query;

import java.util.List;

public class AgencyRepository extends BaseRepository<Agency> {
    @Override
    public Agency findById(int id) {
        session = sessionFactory.openSession();
        Agency agency = session.get(Agency.class,id);
        session.close();
        return agency;
    }

    @Override
    public List<Agency> findAll() {
        List<Agency> agencies = null;
        session = sessionFactory.openSession();
        Query<Agency> agencyQuery = session.createQuery("from Agency ",Agency.class);
        agencies = agencyQuery.list();
        session.close();
        return agencies;
    }
}
