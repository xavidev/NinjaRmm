package com.ninjaone.rmmcustomers.customerdevcies.application.create;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.*;
import com.ninjaone.shared.domain.Service;

@Service
public final class CustomerDeviceCreator {
    private final CustomerDeviceRepository repository;

    public CustomerDeviceCreator(CustomerDeviceRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String customerId, String name) {

        if (repository.search(new CustomerDeviceId(id)).isPresent()) {
            return;
        }

        var device = CustomerDevice.create(
            new CustomerDeviceId(id),
            new SystemName(name + "-" + customerId),
            new DeviceType(name),
            new CustomerId(customerId)
        );

        repository.save(device);
    }
}
