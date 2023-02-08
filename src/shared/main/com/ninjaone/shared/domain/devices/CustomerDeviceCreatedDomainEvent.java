package com.ninjaone.shared.domain.devices;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public class CustomerDeviceCreatedDomainEvent extends DomainEvent {
    private final String deviceId;
    private final String customerId;
    public CustomerDeviceCreatedDomainEvent(String aggregateId, String deviceId, String customerId) {
        super(aggregateId);

        this.customerId = customerId;
        this.deviceId = deviceId;
    }

    public String customerId() {
        return customerId;
    }

    public String deviceId(){
        return deviceId;
    }
}
