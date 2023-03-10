package com.ninjaone.rmm.orders.infrastructure.persistence;

import com.ninjaone.rmm.orders.domain.ServiceOrderRepository;
import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.rmm.orders.domain.model.ServiceOrderId;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("rmm-transaction_manager")
public class MySqlServiceOrderRepository extends HibernateRepository<ServiceOrder> implements ServiceOrderRepository {
    public MySqlServiceOrderRepository(@Qualifier("rmm-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, ServiceOrder.class);
    }

    @Override
    public void save(ServiceOrder service) {
        persist(service);
    }

    @Override
    public Optional<ServiceOrder> search(ServiceOrderId serviceOrderId) {
        return byId(serviceOrderId);
    }
}
