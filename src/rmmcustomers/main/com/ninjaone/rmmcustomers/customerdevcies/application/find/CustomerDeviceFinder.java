package com.ninjaone.rmmcustomers.customerdevcies.application.find;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceNotExistException;
import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerService;
import com.ninjaone.shared.domain.Service;

@Service
public final class CustomerDeviceFinder {
    private final CustomerDeviceRepository repository;

    public CustomerDeviceFinder(CustomerDeviceRepository repository) {
        this.repository = repository;
    }

    public CustomerDeviceResponse find(String orderId, String customerId) {

        CustomerDevice device = this.repository
            .search(new CustomerDeviceId(orderId))
            .orElseThrow(() -> new CustomerDeviceNotExistException(new CustomerDeviceId(orderId)));

        return new CustomerDeviceResponse(
            device.systemName().value(),
            device.type().value(),
            device.services().stream().map(CustomerService::name).toList(),
            String.valueOf(device.totalCost())
        );
    }
}
