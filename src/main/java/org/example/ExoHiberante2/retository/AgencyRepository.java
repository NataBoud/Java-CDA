package org.example.ExoHiberante2.retository;

import org.example.ExoHiberante2.entity.Agency;
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
        List<Agency> agenciesList = null;
        session = sessionFactory.openSession();
        Query<Agency> agencyQuery = session.createQuery("from Agency ",Agency.class);
        agenciesList = agencyQuery.list();
        session.close();
        return agenciesList;
    }
}
