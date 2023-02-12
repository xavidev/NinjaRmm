package com.ninjaone.rmmcustomers.customerdevcies.infrastructure.persistence;

import com.ninjaone.rmmcustomers.customerdevcies.CustomerDevicesModuleInfrastructureTestCase;
import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceMother;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MysqlCustomerDeviceRepositoryShould extends CustomerDevicesModuleInfrastructureTestCase {

    @Test
    void save_customer_device(){
        var customerDevice = CustomerDeviceMother.random();

        repository.save(customerDevice);
    }
}
