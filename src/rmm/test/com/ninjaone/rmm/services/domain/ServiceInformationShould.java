package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.shared.domain.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class ServiceInformationShould {
    @Test
    void calulate_price_for_device_with_no_policies(){
        ServiceInformation serviceInformation = ServiceInformationMother.antivirus("100");

        Price cost = serviceInformation.costFor(DeviceInformationMother.Windows().type());

        Assertions.assertEquals(new Price("100"), cost);
    }

    @Test
    void calculate_service_with_device_cost_policy(){
        ServiceInformation serviceInformation = ServiceInformationMother.antivirus("100");
        serviceInformation.addCostPolicy(
            ServiceCostPolicyMother.forDevice(DeviceInformationMother.Windows(), "200")
        );
        serviceInformation.addCostPolicy(
            ServiceCostPolicyMother.forDevice(DeviceInformationMother.Mac(), "300")
        );

        Price cost = serviceInformation.costFor(DeviceInformationMother.Windows().type());

        Assertions.assertEquals(new Price("200"), cost);
    }
}
