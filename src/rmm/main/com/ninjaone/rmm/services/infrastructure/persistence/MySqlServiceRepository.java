package com.ninjaone.rmm.services.infrastructure.persistence;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@com.ninjaone.shared.domain.Service
@Transactional
public class MySqlServiceRepository extends HibernateRepository<ServiceInformation> implements ServiceRepository {
    public MySqlServiceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, ServiceInformation.class);
    }

    @Override
    public void save(ServiceInformation serviceInformation) {
        persist(serviceInformation);
    }

    @Override
    public List<ServiceInformation> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public Optional<ServiceInformation> search(ServiceId id) {
        return byId(id);
    }

    @Override
    public void delete(ServiceInformation serviceInformation) {
        remove(serviceInformation);
    }
}
