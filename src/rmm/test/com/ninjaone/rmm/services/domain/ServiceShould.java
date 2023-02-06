package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.services.domain.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class ServiceShould {
    @Test
    void calulate_price_for_device_with_no_policies(){
        Service service = ServiceMother.antivirus(100);

        double cost = service.costFor(DeviceMother.Windows());

        Assertions.assertEquals(100, cost);
    }

    @Test
    void calculate_service_with_device_cost_policy(){
        Service service = ServiceMother.antivirus(100);
        service.addCostPolicy(
            ServiceCostPolicyMother.forDevice(DeviceMother.Windows(), 200)
        );
        service.addCostPolicy(
            ServiceCostPolicyMother.forDevice(DeviceMother.Mac(), 300)
        );

        double cost = service.costFor(DeviceMother.Windows());

        Assertions.assertEquals(200, cost);
    }
}
