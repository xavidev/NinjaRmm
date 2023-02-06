package com.ninjaone.rmm.devices.infrastructure.persistence;

import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@com.ninjaone.shared.domain.Service
@Transactional
public class MySqlDeviceRepository extends HibernateRepository<Device> implements DeviceRepository {
    public MySqlDeviceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Device.class);
    }

    @Override
    public void save(Device device) {

    }

    @Override
    public List<Device> matching(Criteria criteria) {
        List<Device> device = Collections.emptyList();
        return device;
    }
}
