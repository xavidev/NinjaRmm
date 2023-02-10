package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.orders.domain.model.DeviceOrder;
import com.ninjaone.rmm.orders.domain.model.DeviceOrderId;
import com.ninjaone.rmm.orders.domain.model.OrderName;
import com.ninjaone.rmm.shared.domain.UuidMother;
import com.ninjaone.shared.domain.CustomerId;
import com.ninjaone.shared.domain.DeviceId;

public final class DeviceOrderMother {
    public static DeviceOrder from(DeviceInformation device) {
        return DeviceOrder.orderFor(
            new DeviceOrderId(UuidMother.random()),
            new DeviceId(device.id()),
            new CustomerId(UuidMother.random()),
            new OrderName(device.type())
        );
    }
}
