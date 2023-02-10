package com.ninjaone.rmm.orders.persistence;

import com.ninjaone.rmm.orders.OrdersModuleInfrastructueTestCase;
import com.ninjaone.rmm.orders.domain.ServiceOrderMother;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MySqlServiceOrderRepositoryShould extends OrdersModuleInfrastructueTestCase {

    @Test
    public void should_save_service_order(){
        var serviceOrder = ServiceOrderMother.random();

        repository.save(serviceOrder);
    }

}
