package com.ninjaone.apps.rmm.controller.devices;

import com.ninjaone.rmm.devices.application.create.CreateDeviceCommand;
import com.ninjaone.shared.domain.DomainException;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class DevicePutController extends ApiController {

    public DevicePutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/devices/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody DeviceRequest request) {
        dispatch(new CreateDeviceCommand(id, request.type(), request.cost()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return null;
    }
}

class DeviceRequest {

    private String type;
    private double cost;
    public DeviceRequest() {
    }

    public String type() {
        return type;
    }

    public double cost() {
        return cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
