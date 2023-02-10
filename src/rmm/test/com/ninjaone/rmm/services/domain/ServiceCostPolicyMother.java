package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.shared.domain.ForSameServiceCostPolicy;
import com.ninjaone.rmm.shared.domain.PerDeviceTypeCostPolicy;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.shared.domain.ServiceCostPolicy;


public final class ServiceCostPolicyMother {

    public static ServiceCostPolicy random() {
        return new PerDeviceTypeCostPolicy("WIN", "10");
    }

    public static ServiceCostPolicy forDevice(DeviceInformation deviceInformation, String cost) {
        return new PerDeviceTypeCostPolicy(deviceInformation.type(), cost);
    }

    public static ServiceCostPolicy forSameServices(String serviceName, String numOfServices, String discount) {
        return new ForSameServiceCostPolicy(serviceName, numOfServices, discount);
    }
}
