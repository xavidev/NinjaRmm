package com.ninjaone.rmm.orders.domain;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public final class ServiceOrderCreatedDomainEvent extends DomainEvent {
    private String name;
    private String deviceId;
    private String serviceId;
    private String customerId;

    public ServiceOrderCreatedDomainEvent(String aggregateId, String deviceId, String serviceId, String name, String customerId) {
        super(aggregateId);
        this.deviceId = deviceId;
        this.serviceId = serviceId;
        this.name = name;
        this.customerId = customerId;
    }

    public String name() {
        return name;
    }

    public String deviceId() {
        return deviceId;
    }

    public String serviceId() {
        return serviceId;
    }

    public String customerId() {
        return customerId;
    }

    public String itemType(){
        return "service";
    }
}
