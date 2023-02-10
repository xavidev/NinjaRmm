package com.ninjaone.rmm.orders.domain.model;

import com.ninjaone.rmm.orders.domain.ServiceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.CustomerId;
import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.domain.ServiceId;

public class ServiceOrder extends AggregateRoot {

    private ServiceOrderId id;
    private ServiceId serviceId;

    private OrderName name;
    private DeviceId deviceId;
    private CustomerId customerId;

    private ServiceOrder(ServiceOrderId id, ServiceId serviceId, DeviceId deviceId, CustomerId customerId, OrderName name) {
        this.id = id;
        this.serviceId = serviceId;
        this.deviceId = deviceId;
        this.customerId = customerId;
        this.name = name;

        record(new ServiceOrderCreatedDomainEvent(id.value(), deviceId.value(), serviceId.value(), customerId.value(), name.value()));
    }

    public static ServiceOrder create(ServiceOrderId id, ServiceId serviceId, DeviceId deviceId, CustomerId customerId, OrderName name) {
        return new ServiceOrder(
            id,
            serviceId,
            deviceId,
            customerId,
            name
        );
    }

    public String id() {
        return id.toString();
    }

    public String serviceId() {
        return serviceId.toString();
    }

    public String deviceId() {
        return deviceId.toString();
    }

    public String customerId() {
        return customerId.toString();
    }

    public String name() {
        return name.value();
    }
}
