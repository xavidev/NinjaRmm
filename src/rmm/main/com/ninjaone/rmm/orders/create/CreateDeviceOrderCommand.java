package com.ninjaone.rmm.orders.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateDeviceOrderCommand implements Command {
    private final String orderId;
    private final String deviceId;
    private final String customerId;

    public CreateDeviceOrderCommand(String orderId, String deviceId, String customerId) {
        this.orderId = orderId;
        this.deviceId = deviceId;
        this.customerId = customerId;
    }

    public String orderId() {
        return orderId;
    }
    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }
}
