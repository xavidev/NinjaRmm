package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.rmmcustomers.devices.application.create.CreateCustomerDeviceCommand;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class CustomerDevicePutController {
    private final CommandBus bus;

    public CustomerDevicePutController(CommandBus bus) {

        this.bus = bus;
    }

    @PutMapping(path = "/devices/{id}")
    public @ResponseBody ResponseEntity<String> index(@PathVariable String id, @RequestBody DeviceRequest request) {
        bus.dispatch(new CreateCustomerDeviceCommand(id, request.getDeviceId(), request.getCustomerId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

@Data
class DeviceRequest {
    private String deviceId;
    private String customerId;
}
