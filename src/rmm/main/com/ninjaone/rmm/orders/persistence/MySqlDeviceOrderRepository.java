package com.ninjaone.rmm.orders.persistence;

import com.ninjaone.rmm.orders.domain.DeviceOrderRepository;
import com.ninjaone.rmm.orders.domain.model.DeviceOrder;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional("rmm-transaction_manager")
public class MySqlDeviceOrderRepository extends HibernateRepository<DeviceOrder> implements DeviceOrderRepository {
    public MySqlDeviceOrderRepository(@Qualifier("rmm-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, DeviceOrder.class);
    }

    @Override
    public void save(DeviceOrder device) {
        persist(device);
    }
}
