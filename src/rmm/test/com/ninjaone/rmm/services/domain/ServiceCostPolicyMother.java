package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceCostPolicy;

public final class ServiceCostPolicyMother {

    public static ServiceCostPolicy random() {
        return ServiceCostPolicy.create("WIN", "10");
    }

    public static ServiceCostPolicy forDevice(DeviceInformation deviceInformation, String cost) {
        return ServiceCostPolicy.create(deviceInformation.type(), cost);
    }
}
