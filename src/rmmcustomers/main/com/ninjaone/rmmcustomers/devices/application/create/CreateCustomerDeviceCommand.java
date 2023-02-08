package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateCustomerDeviceCommand implements Command {
    private final String deviceId;
    private final String customerId;

    public CreateCustomerDeviceCommand(String deviceId, String customerId) {
        this.deviceId = deviceId;
        this.customerId = customerId;
    }

    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }
}
