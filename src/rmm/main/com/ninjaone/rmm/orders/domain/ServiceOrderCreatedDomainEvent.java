package com.ninjaone.rmm.orders.domain;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

import java.util.Objects;

public final class ServiceOrderCreatedDomainEvent extends DomainEvent {
    private String name;
    private String deviceId;
    private String serviceId;
    private String customerId;

    public ServiceOrderCreatedDomainEvent(String aggregateId, String deviceId, String serviceId, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrderCreatedDomainEvent that = (ServiceOrderCreatedDomainEvent) o;
        return Objects.equals(name, that.name) && Objects.equals(deviceId, that.deviceId) && Objects.equals(serviceId, that.serviceId) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, deviceId, serviceId, customerId);
    }
}
