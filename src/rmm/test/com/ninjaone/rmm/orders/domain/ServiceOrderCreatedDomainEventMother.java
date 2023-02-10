package com.ninjaone.rmm.orders.domain;

import com.ninjaone.rmm.orders.domain.model.ServiceOrder;

public final class ServiceOrderCreatedDomainEventMother {
    public static ServiceOrderCreatedDomainEvent fromOrder(ServiceOrder order) {
        return new ServiceOrderCreatedDomainEvent(
            order.id(),
            order.deviceId(),
            order.serviceId(),
            order.customerId()
        );
    }
}
