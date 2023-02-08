package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.rmmcustomers.devices.domain.model.CustomerDevice;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandBus;

import java.util.List;

@Service
public final class DeviecCreator {
    public DeviecCreator(CommandBus bus) {
        this.customerDeviceRepository = customerDeviceRepository;
    }

    public void create(String customerId, String deviceId, List<String> services){


        CustomerDevice device = CustomerDevice.create(customerId, deviceId, services);

        customerDeviceRepository.save(device);
    }
}
