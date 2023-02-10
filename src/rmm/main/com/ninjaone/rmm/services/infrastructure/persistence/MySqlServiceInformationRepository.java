package com.ninjaone.rmm.services.infrastructure.persistence;

import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.ServiceId;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@com.ninjaone.shared.domain.Service
@Transactional("rmm-transaction_manager")
public class MySqlServiceInformationRepository extends HibernateRepository<ServiceInformation> implements ServiceInformationRepository {
    public MySqlServiceInformationRepository(@Qualifier("rmm-session_factory") SessionFactory sessionFactory) {
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
