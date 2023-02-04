package com.ninjaone.rmm.services.infrastructure.persistence;

import com.ninjaone.rmm.services.domain.DeviceServiceRepository;
import com.ninjaone.rmm.services.domain.model.DeviceService;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MySqlDeviceServiceRepository extends HibernateRepository<DeviceService> implements DeviceServiceRepository {
    public MySqlDeviceServiceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, DeviceService.class);
    }

    @Override
    public void save(DeviceService service) {
        persist(service);
    }
}
