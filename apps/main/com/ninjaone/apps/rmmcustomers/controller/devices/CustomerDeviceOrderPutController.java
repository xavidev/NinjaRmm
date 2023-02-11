package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.rmm.orders.create.CreateDeviceOrderCommand;
import com.ninjaone.shared.domain.DomainException;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public final class CustomerDeviceOrderPutController extends ApiController {
    public CustomerDeviceOrderPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(path = "/orders/{id}/devices/{deviceId}")
    public @ResponseBody ResponseEntity<String> index(
        @PathVariable String id,
        @PathVariable String deviceId,
        @RequestBody DeviceRequest request) {
        dispatch(new CreateDeviceOrderCommand(id, deviceId, request.getCustomerId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return null;
    }
}

@Data
class DeviceRequest {
    private String customerId;
}
