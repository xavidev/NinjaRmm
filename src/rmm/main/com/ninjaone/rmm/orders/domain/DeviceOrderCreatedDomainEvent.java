package com.ninjaone.rmm.orders.domain;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public final class DeviceOrderCreatedDomainEvent extends DomainEvent {
    private final String deviceId;
    private final String customerId;

    private final String name;

    public DeviceOrderCreatedDomainEvent(String id, String deviceId, String customerId, String name) {
        super(id);

        this.deviceId = deviceId;
        this.customerId = customerId;
        this.name = name;
    }

    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }

    public String name(){
        return name;
    }

    public String itemType(){
        return "device";
    }
}
