package com.ninjaone.rmmcustomers.customerdevcies.domain;

import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.DeviceType;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.SystemName;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.UuidMother;

public final class CustomerDeviceMother {
    public static CustomerDevice random() {
        return CustomerDevice.create(
            new CustomerDeviceId(UuidMother.random()),
            new SystemName("random"),
            new DeviceType("Windows"),
            new Price("200")
        );
    }
}
