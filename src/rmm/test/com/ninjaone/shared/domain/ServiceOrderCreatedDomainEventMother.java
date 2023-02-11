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

    public static ServiceOrderCreatedDomainEvent invalid() {
        return new InvalidServiceOrderDomainEvent(
            UuidMother.random(),
            UuidMother.random(),
            UuidMother.random(),
            UuidMother.random(),
            UuidMother.random()
        );
    }
}

class InvalidServiceOrderDomainEvent extends ServiceOrderCreatedDomainEvent {

    public InvalidServiceOrderDomainEvent(String aggregateId, String deviceId, String serviceId, String name, String customerId) {
        super(aggregateId, deviceId, serviceId, name, customerId);
    }

    @Override
    public String itemType() {
        return "INVALID";
    }
}
