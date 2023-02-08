package com.ninjaone.rmmcustomers.services.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateCustomerServiceCommand implements Command {
    private final String serviceId;
    private final String deviceId;
    private final String customerId;

    public CreateCustomerServiceCommand(String serviceId, String deviceId, String customerId) {

        this.serviceId = serviceId;
        this.deviceId = deviceId;
        this.customerId = customerId;
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
