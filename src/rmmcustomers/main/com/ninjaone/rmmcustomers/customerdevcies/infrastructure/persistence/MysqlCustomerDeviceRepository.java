package com.ninjaone.rmmcustomers.customerdevcies.infrastructure.persistence;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("rmmcustomers-transaction_manager")
public class MysqlCustomerDeviceRepository extends HibernateRepository<CustomerDevice> implements CustomerDeviceRepository {
    public MysqlCustomerDeviceRepository(@Qualifier("rmmcustomers-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, CustomerDevice.class);
    }

    @Override
    public void save(CustomerDevice device) {
        persist(device);
    }

    @Override
    public Optional<CustomerDevice> search(CustomerDeviceId customerDeviceId) {
        return byId(customerDeviceId);
    }

    @Override
    public List<CustomerDevice> match(Criteria criteria) {
        return byCriteria(criteria);
    }
}
