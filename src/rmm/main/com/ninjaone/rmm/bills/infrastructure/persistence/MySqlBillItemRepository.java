package com.ninjaone.rmm.bills.infrastructure.persistence;

import com.ninjaone.rmm.bills.domain.BillItemRepository;
import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("rmm-transaction_manager")
public class MySqlBillItemRepository extends HibernateRepository<BillItem> implements BillItemRepository {
    public MySqlBillItemRepository(@Qualifier("rmm-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, BillItem.class);
    }

    @Override
    public void save(BillItem item) {
        persist(item);
    }
}
