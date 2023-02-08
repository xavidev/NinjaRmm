package com.ninjaone.rmm.costs.domain.model;

import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.devices.DeviceCostCreatedDomainEvent;

public final class DeviceCost extends AggregateRoot {
    private DeviceCostId id;
    private double cost;
    private String customerId;

    private DeviceCost(DeviceCostId id, String customerId, double cost, String type) {
        this.id = id;
        this.customerId = customerId;
        this.cost = cost;

        record(new DeviceCostCreatedDomainEvent(id.value(), customerId, cost, type));
    }

    private DeviceCost(){

    }

    public static DeviceCost create(String id, String customerId, double cost, String type) {
        return new DeviceCost(new DeviceCostId(id), customerId, cost, type);
    }

    public String id() {
        return id.value();
    }
}
