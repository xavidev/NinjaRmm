package com.ninjaone.rmmcustomers.customerdevcies.infrastructure.persistence;

import com.ninjaone.rmmcustomers.customerdevcies.CustomerDevicesModuleInfrastructureTestCase;
import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceMother;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MysqlCustomerDeviceRepositoryShould extends CustomerDevicesModuleInfrastructureTestCase {

    @Test
    void save_customer_device(){
        repository.save(CustomerDeviceMother.random());
    }

    @Test
    void save_customer_device_with_services(){
        repository.save(CustomerDeviceMother.randomWithServices());
    }
}
