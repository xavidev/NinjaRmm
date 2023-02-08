package com.ninjaone.rmm.devices.infrastructure.persistence;

import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.devices.domain.model.DeviceId;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@com.ninjaone.shared.domain.Service
@Transactional
public class MySqlDeviceRepository extends HibernateRepository<DeviceInformation> implements DeviceRepository {
    public MySqlDeviceRepository(SessionFactory sessionFactory) {
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
