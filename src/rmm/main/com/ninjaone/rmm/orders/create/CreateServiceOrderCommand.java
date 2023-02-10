package com.ninjaone.rmm.orders.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateServiceOrderCommand implements Command {
    private final String customerServiceId;
    private final String serviceId;
    private final String deviceId;
    private final String customerId;

    public CreateServiceOrderCommand(String customerServiceId, String serviceId, String deviceId, String customerId) {
        this.customerServiceId = customerServiceId;
        this.serviceId = serviceId;
        this.deviceId = deviceId;
        this.customerId = customerId;
    }

    public String serviceId() {
        return serviceId;
    }

    public String customerServiceId() {
        return customerServiceId;
    }

    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }
}
