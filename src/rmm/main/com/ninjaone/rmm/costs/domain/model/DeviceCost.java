package com.ninjaone.rmm.costs.domain.model;

import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.devices.DeviceCostCreatedDomainEvent;

import java.util.UUID;

public final class DeviceCost extends AggregateRoot {
    private DeviceCostId id;
    private double cost;
    private String deviceId;
    private String customerId;

    private DeviceCost(DeviceCostId id, String deviceId, String customerId, double cost, String type) {
        this.id = id;
        this.deviceId = deviceId;
        this.customerId = customerId;
        this.cost = cost;

        record(new DeviceCostCreatedDomainEvent(id.value(), customerId, cost, type));
    }

    private DeviceCost(){

    }

    public static DeviceCost create(String deviceId, String customerId, double cost, String type) {
        return new DeviceCost(new DeviceCostId(UUID.randomUUID().toString()), deviceId, customerId, cost, type);
    }

    public String id() {
        return id.value();
    }

    public double cost() {
        return cost;
    }

    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }
}
