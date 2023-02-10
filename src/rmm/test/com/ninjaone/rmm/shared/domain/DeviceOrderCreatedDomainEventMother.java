package com.ninjaone.rmm.shared.domain;

import com.ninjaone.rmm.orders.domain.DeviceOrderCreatedDomainEvent;
import com.ninjaone.rmm.orders.domain.model.DeviceOrder;

public final class DeviceOrderCreatedDomainEventMother {
    public static DeviceOrderCreatedDomainEvent from(DeviceOrder order) {
        return new DeviceOrderCreatedDomainEvent(order.id(), order.deviceId(), order.customerId(), order.name());
    }
}
