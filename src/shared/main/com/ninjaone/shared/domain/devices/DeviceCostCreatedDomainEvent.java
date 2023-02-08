package com.ninjaone.shared.domain.devices;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public final class DeviceCostCreatedDomainEvent extends DomainEvent {
    private final String customerId;
    private final double cost;
    private final String type;

    public DeviceCostCreatedDomainEvent(String deviceId, String customerId, double cost, String type) {
        super(deviceId);
        this.customerId = customerId;
        this.cost = cost;
        this.type = type;
    }

    public String customerId() {
        return customerId;
    }

    public double cost() {
        return cost;
    }

    public String type() {
        return type;
    }

    public String itemType() {
        return "device";
    }
}
