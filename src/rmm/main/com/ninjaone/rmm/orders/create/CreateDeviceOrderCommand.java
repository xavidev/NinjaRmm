package com.ninjaone.rmm.orders.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateDeviceOrderCommand implements Command {
    private final String customerDeviceId;
    private final String deviceId;
    private final String customerId;

    public CreateDeviceOrderCommand(String customerDeviceId, String deviceId, String customerId) {
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
