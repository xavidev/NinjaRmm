package com.ninjaone.rmmcustomers.devices.application.assignservice;

import com.ninjaone.rmmcustomers.devices.domain.CustomerDeviceRepository;
import com.ninjaone.shared.domain.bus.event.EventBus;

public final class CustomerDeviceServiceAssigner {

    private final CustomerDeviceRepository customerDeviceRepository;
    private EventBus bus;

    public CustomerDeviceServiceAssigner(CustomerDeviceRepository customerDeviceRepository) {
        this.customerDeviceRepository = customerDeviceRepository;
    }

    public void assignToDevice(String deviceId, String serviceId) {

    }
}
