package com.ninjaone.rmm.orders.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateServiceOrderCommand implements Command {
    private final String serviceId;
    private final String orderId;
    private final String deviceId;
    private final String customerId;

    public CreateServiceOrderCommand(String orderId, String serviceId, String deviceId, String customerId) {
        this.orderId = orderId;
        this.serviceId = serviceId;
        this.deviceId = deviceId;
        this.customerId = customerId;
    }

    public String orderId() {
        return orderId;
    }

    public String serviceId() {
        return serviceId;
    }

    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }
}
