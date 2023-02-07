package com.ninjaone.rmm.services.infrastructure.persistence;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@com.ninjaone.shared.domain.Service
@Transactional
public class MySqlServiceRepository extends HibernateRepository<Service> implements ServiceRepository {
    public MySqlServiceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Service.class);
    }

    @Override
    public void save(Service service) {
        persist(service);
    }

    @Override
    public List<Service> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public Optional<Service> search(ServiceId id) {
        return byId(id);
    }

    @Override
    public void delete(Service service) {
        remove(service);
    }
}
