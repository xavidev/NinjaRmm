package com.ninjaone.rmmcustomers.customerdevcies.domain;

import com.ninjaone.rmmcustomers.customerdevcies.domain.model.*;
import com.ninjaone.shared.domain.UuidMother;

public final class CustomerDeviceMother {
    public static CustomerDevice random() {
        return CustomerDevice.create(
            new CustomerDeviceId(UuidMother.random()),
            new SystemName("random"),
            new DeviceType("Windows")
        );
    }

    public static CustomerDevice randomWithServices() {
        var device = random();

        device.addService(new CustomerService(UuidMother.random(), "random"));
        device.addService(new CustomerService(UuidMother.random(), "random"));
        device.addService(new CustomerService(UuidMother.random(), "random"));

        return device;
    }
}
