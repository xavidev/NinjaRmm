package com.ninjaone.apps.rmmcustomers.controller.services;

import com.ninjaone.rmmcustomers.devices.application.create.CreateCustomerDeviceCommand;
import com.ninjaone.rmmcustomers.services.application.create.CreateCustomerServiceCommand;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public final class CustomerServicePutController {
    private final CommandBus bus;

    public CustomerServicePutController(CommandBus bus) {

        this.bus = bus;
    }

    @PutMapping(path = "/services/{id}")
    public @ResponseBody ResponseEntity<String> index(@PathVariable String id, @RequestBody ServiceRequest request) {
        bus.dispatch(new CreateCustomerServiceCommand(id, request.getDeviceId(), request.getCustomerId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

@Data
class ServiceRequest {
    private String deviceId;
    private String customerId;
}
