package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.rmmcustomers.devices.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.devices.domain.model.CustomerDevice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public final class CustomerDevicePutController {

    private final CustomerDeviceRepository customerDeviceRepository;

    public CustomerDevicePutController(CustomerDeviceRepository customerDeviceRepository) {
        this.customerDeviceRepository = customerDeviceRepository;
    }

    @PutMapping(path = "/devices/{id}")
    public @ResponseBody String addNewUser(@PathVariable String id) {

        CustomerDevice device = CustomerDevice.create(UUID.randomUUID(), 100, "testing");

        customerDeviceRepository.save(device);

        return "Saved";
    }
}
