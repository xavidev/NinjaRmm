package com.ninjaone.apps.rmm.controller.orders;

import com.ninjaone.rmm.orders.create.CreateServiceOrderCommand;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public final class ServiceOrderPutController {
    private final CommandBus bus;

    public ServiceOrderPutController(CommandBus bus) {

        this.bus = bus;
    }

    @PutMapping(path = "/services/{serviceId}/order/{id}")
    public @ResponseBody ResponseEntity<String> index(
        @PathVariable String serviceId,
        @PathVariable String id,
        @RequestBody ServiceRequest request) {

        bus.dispatch(new CreateServiceOrderCommand(serviceId, id, request.getDeviceId(), request.getCustomerId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

@Data
class ServiceRequest {
    private String deviceId;
    private String customerId;
}
