package com.ninjaone.shared.domain;

import com.ninjaone.rmm.orders.domain.ServiceOrderCreatedDomainEvent;
import com.ninjaone.rmm.orders.domain.model.DeviceOrder;
import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.rmm.shared.domain.UuidMother;

public final class ServiceOrderCreatedDomainEventMother {
    public static ServiceOrderCreatedDomainEvent from(DeviceOrder device, ServiceOrder service) {
        return new ServiceOrderCreatedDomainEvent(
            UuidMother.random(),
            device.deviceId(),
            service.serviceId(),
            service.name(),
            service.customerId()
            );
    }
}
