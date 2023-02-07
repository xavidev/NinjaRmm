package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.rmmcustomers.devices.application.create.CustomerDeviceCreator;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public final class CustomerDevicePutController {

    private final CustomerDeviceCreator creator;

    public CustomerDevicePutController(CustomerDeviceCreator creator) {

        this.creator = creator;
    }

    @PutMapping(path = "/devices/{id}")
    public @ResponseBody ResponseEntity<String> index(@PathVariable String id, @RequestBody DeviceRequest request) {
        creator.create(id, request.getDeviceId(), request.getCustomerId());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

@Data
class DeviceRequest {

    private String deviceId;
    private String customerId;
}
