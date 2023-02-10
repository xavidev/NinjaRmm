package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class ServiceInformationShould {
    @Test
    void calulate_price_for_device_with_no_policies(){
        ServiceInformation serviceInformation = ServiceInformationMother.antivirus(100);

        double cost = serviceInformation.costFor(DeviceMother.Windows().type());

        Assertions.assertEquals(100, cost);
    }

    @Test
    void calculate_service_with_device_cost_policy(){
        ServiceInformation serviceInformation = ServiceInformationMother.antivirus(100);
        serviceInformation.addCostPolicy(
            ServiceCostPolicyMother.forDevice(DeviceMother.Windows(), 200)
        );
        serviceInformation.addCostPolicy(
            ServiceCostPolicyMother.forDevice(DeviceMother.Mac(), 300)
        );

        double cost = serviceInformation.costFor(DeviceMother.Windows().type());

        Assertions.assertEquals(200, cost);
    }
}
