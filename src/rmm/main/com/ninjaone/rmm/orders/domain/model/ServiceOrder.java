package com.ninjaone.rmm.orders.domain.model;

import com.ninjaone.rmm.orders.domain.ServiceOrderCreatedDomainEvent;
import com.ninjaone.rmm.services.domain.model.ServiceName;
import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.CustomerId;
import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.domain.ServiceId;

import java.util.Objects;

public class ServiceOrder extends AggregateRoot {

    private ServiceOrderId id;
    private ServiceId serviceId;
    private DeviceId deviceId;
    private CustomerId customerId;

    private OrderName name;

    private ServiceOrder(ServiceOrderId id, ServiceId serviceId, OrderName name, DeviceId deviceId, CustomerId customerId) {
        this.id = id;
        this.serviceId = serviceId;
        this.name = name;
        this.deviceId = deviceId;
        this.customerId = customerId;

        record(new ServiceOrderCreatedDomainEvent(id.value(), deviceId.value(), serviceId.value(), customerId.value()));
    }

    protected ServiceOrder(){

    }
    public static ServiceOrder create(ServiceOrderId id, ServiceId serviceId, OrderName name, DeviceId deviceId, CustomerId customerId) {
        return new ServiceOrder(
            id,
            serviceId,
            name,
            deviceId,
            customerId
        );
    }

    public String id() {
        return id.value();
    }

    public String serviceId() {
        return serviceId.value();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(serviceId, that.serviceId) &&
            Objects.equals(deviceId, that.deviceId) &&
            Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceId, deviceId, customerId);
    }
}
