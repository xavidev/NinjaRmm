package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

import java.util.List;

public final class CreateCustomerDevice implements Command {
    private String deviceId;
    private String customerId;
    private List<String> services;

    public CreateCustomerDevice(String deviceId, String customerId, List<String> services) {

        this.deviceId = deviceId;
        this.customerId = customerId;
        this.services = services;
    }

    public String deviceId() {
        return deviceId;
    }

    public String customerId() {
        return customerId;
    }

    public List<String> services() {
        return services;
    }
}
