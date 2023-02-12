package com.ninjaone.rmmcustomers.customerdevcies.application.create;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.DeviceType;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.SystemName;
import com.ninjaone.shared.domain.Service;

@Service
public final class CustomerDeviceCreator {
    private final CustomerDeviceRepository repository;

    public CustomerDeviceCreator(CustomerDeviceRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String deviceId, String customerId, String name) {
        var device = CustomerDevice.create(
            new CustomerDeviceId(id),
            new SystemName(name + "-" + customerId),
            new DeviceType(name)
        );

        repository.save(device);
    }
}
