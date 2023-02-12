package com.ninjaone.rmm.orders.infrastructure.persistence;

import com.ninjaone.rmm.orders.domain.DeviceOrderRepository;
import com.ninjaone.rmm.orders.domain.model.DeviceOrder;
import com.ninjaone.rmm.orders.domain.model.DeviceOrderId;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("rmm-transaction_manager")
public class MySqlDeviceOrderRepository extends HibernateRepository<DeviceOrder> implements DeviceOrderRepository {
    public MySqlDeviceOrderRepository(@Qualifier("rmm-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, DeviceOrder.class);
    }

    @Override
    public void save(DeviceOrder device) {
        persist(device);
    }

    @Override
    public Optional<DeviceOrder> search(DeviceOrderId id) {
        return byId(id);
    }
}
