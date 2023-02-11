package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.orders.domain.ServiceOrderCreatedDomainEvent;

public final class BillCreationParamsMother {
    public static BillCreationParams fromServiceOrderEvent(ServiceOrderCreatedDomainEvent event) {
        return new BillCreationParams(
            event.aggregateId(),
            event.name(),
            event.deviceId(),
            event.serviceId(),
            event.customerId(),
            event.itemType()
        );
    }
}
