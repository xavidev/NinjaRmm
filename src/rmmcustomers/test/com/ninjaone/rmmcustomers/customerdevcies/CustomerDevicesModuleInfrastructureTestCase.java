package com.ninjaone.rmmcustomers.customerdevcies;

import com.ninjaone.apps.rmmcustomers.RmmCustomersBackendApplication;
import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = RmmCustomersBackendApplication.class)
@SpringBootTest
public abstract class CustomerDevicesModuleInfrastructureTestCase {

    @Autowired
    protected CustomerDeviceRepository repository;
}
