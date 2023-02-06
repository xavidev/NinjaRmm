package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.rmm.services.domain.model.ServiceCostPolicy;

public final class ServiceCostPolicyMother {

    public static ServiceCostPolicy random() {
        return ServiceCostPolicy.create(ServiceCostIdMother.random().value(), 10, "WIN");
    }

    public static ServiceCostPolicy deviceCost(double cost) {
        return ServiceCostPolicy.create(ServiceCostIdMother.random().value(), cost, null);
    }

    public static ServiceCostPolicy forDeviceType(Device windows, int cost) {
        return ServiceCostPolicy.create(ServiceCostIdMother.random().value(), cost, windows.type());
    }

    public static ServiceCostPolicy antivirus(double cost) {
        return ServiceCostPolicy.create(ServiceCostIdMother.random().value(), 20, null);
    }

    public static ServiceCostPolicy forDevice(Device device, double cost) {
        return ServiceCostPolicy.create(ServiceCostIdMother.random().value(), cost, device.type());
    }
}
