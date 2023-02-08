package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceCostPolicy;

public final class ServiceCostPolicyMother {

    public static ServiceCostPolicy random() {
        return ServiceCostPolicy.create(10, "WIN");
    }

    public static ServiceCostPolicy deviceCost(double cost) {
        return ServiceCostPolicy.create(cost, null);
    }

    public static ServiceCostPolicy forDeviceType(DeviceInformation windows, int cost) {
        return ServiceCostPolicy.create(cost, windows.type());
    }

    public static ServiceCostPolicy antivirus(double cost) {
        return ServiceCostPolicy.create(20, null);
    }

    public static ServiceCostPolicy forDevice(DeviceInformation deviceInformation, double cost) {
        return ServiceCostPolicy.create(cost, deviceInformation.type());
    }
}
