package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.rmmcustomers.devices.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.devices.domain.model.CustomerDevice;
import com.ninjaone.shared.domain.Service;

@Service
public final class CustomerDeviceCreator {

    private final CustomerDeviceRepository customerDeviceRepository;

    public CustomerDeviceCreator(CustomerDeviceRepository customerDeviceRepository) {
        this.customerDeviceRepository = customerDeviceRepository;
    }

    public void create(String id, String deviceId, String customerId){
        CustomerDevice device = CustomerDevice.create(id, deviceId,customerId);

        customerDeviceRepository.save(device);
    }
}
