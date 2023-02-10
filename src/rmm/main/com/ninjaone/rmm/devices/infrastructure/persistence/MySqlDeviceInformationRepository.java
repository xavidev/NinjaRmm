package com.ninjaone.rmm.devices.infrastructure.persistence;

import com.ninjaone.rmm.devices.domain.DeviceInformationRepository;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.shared.domain.DeviceId;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@com.ninjaone.shared.domain.Service
@Transactional("rmm-transaction_manager")
public class MySqlDeviceInformationRepository extends HibernateRepository<DeviceInformation> implements DeviceInformationRepository {
    public MySqlDeviceInformationRepository(@Qualifier("rmm-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, DeviceInformation.class);
    }

    @Override
    public void save(DeviceInformation deviceInformation) {
        persist(deviceInformation);
    }

    @Override
    public List<DeviceInformation> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public Optional<DeviceInformation> search(DeviceId id) {
        return byId(id);
    }

    @Override
    public void delete(DeviceInformation deviceInformation) {
        remove(deviceInformation);
    }
}
