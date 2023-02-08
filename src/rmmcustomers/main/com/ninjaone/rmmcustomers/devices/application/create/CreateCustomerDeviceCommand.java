package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateCustomerDeviceCommand implements Command {
    private String customerDeviceId;
    private final String deviceId;
    private final String customerId;

    public CreateCustomerDeviceCommand(String customerDeviceId, String deviceId, String customerId) {
        this.customerDeviceId = customerDeviceId;
        this.deviceId = deviceId;
        this.customerId = customerId;
    }

    public String customerDeviceId() {
        return customerDeviceId;
    }
    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }
}
