package com.ninjaone.rmm.orders.persistence;

import com.ninjaone.rmm.orders.domain.ServiceOrderRepository;
import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional("rmm-transaction_manager")
public class MySqlCustomerServiceRepository extends HibernateRepository<ServiceOrder> implements ServiceOrderRepository {
    public MySqlCustomerServiceRepository(@Qualifier("rmm-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, ServiceOrder.class);
    }

    @Override
    public void save(ServiceOrder service) {
        persist(service);
    }
}
