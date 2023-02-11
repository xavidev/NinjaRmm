package com.ninjaone.rmm.bills.infrastructure;

import com.ninjaone.apps.rmm.RmmBackendApplication;
import com.ninjaone.rmm.bills.domain.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = RmmBackendApplication.class)
@SpringBootTest
public class BillModuleInfrastructureTestCase {

    @Autowired
    protected BillItemRepository repository;
}
