package com.ninjaone.rmm.orders;

import com.ninjaone.apps.rmm.RmmBackendApplication;
import com.ninjaone.rmm.orders.domain.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = RmmBackendApplication.class)
@SpringBootTest
public class OrdersModuleInfrastructueTestCase {

    @Autowired
    protected ServiceOrderRepository repository;
}
