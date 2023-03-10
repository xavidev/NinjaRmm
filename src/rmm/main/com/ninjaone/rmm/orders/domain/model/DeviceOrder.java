package com.ninjaone.rmm.orders.domain.model;

import com.ninjaone.shared.domain.orders.DeviceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.rmm.shared.domain.CustomerId;
import com.ninjaone.rmm.shared.domain.DeviceId;

public class DeviceOrder extends AggregateRoot {
    private DeviceOrderId id;
    private DeviceId deviceId;
    private CustomerId customerId;

    private OrderName name;

    private DeviceOrder(DeviceOrderId id, DeviceId deviceId, CustomerId customerId, OrderName name) {
        this.id = id;
        this.deviceId = deviceId;
        this.customerId = customerId;
        this.name = name;

        record(new DeviceOrderCreatedDomainEvent(id.value(), deviceId.value(), customerId.value(), name.value()));
    }

    protected DeviceOrder() {

    }

    public static DeviceOrder orderFor(DeviceOrderId id, DeviceId deviceId, CustomerId customerId, OrderName name) {
        return new DeviceOrder(
            id,
            deviceId,
            customerId,
            name);
    }

    public String id() {
        return id.value();
    }

    public String deviceId() {
        return deviceId.value();
    }

    public String customerId() {
        return customerId.value();
    }

    public String name() {
        return name.value();
    }
}
