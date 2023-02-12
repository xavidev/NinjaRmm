package com.ninjaone.rmmcustomers.customerdevcies.infrastructure.persistence;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("rmmcustomers-transaction_manager")
public class MysqlCustomerDeviceRepository extends HibernateRepository<CustomerDevice> implements CustomerDeviceRepository {
    public MysqlCustomerDeviceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, CustomerDevice.class);
    }

    @Override
    public void save(CustomerDevice device) {
        persist(device);
    }
}
