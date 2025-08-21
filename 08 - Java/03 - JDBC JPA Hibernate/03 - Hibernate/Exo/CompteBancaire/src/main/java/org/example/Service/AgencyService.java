package org.example.Service;

import org.example.entity.Agency;
import org.example.repository.AgencyRepository;
import org.example.repository.BaseRepository;

public class AgencyService extends BaseService<Agency> {
    public AgencyService() {
        super(new AgencyRepository());
    }
}
