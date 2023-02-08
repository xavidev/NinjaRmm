package com.ninjaone.shared.domain.devices;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public class CustomerDeviceCreatedDomainEvent extends DomainEvent {
    private String customerId;
    public CustomerDeviceCreatedDomainEvent(String aggregateId, String customerId) {
        super(aggregateId);

    }

    public String customerId() {
        return customerId;
    }
}
