package com.ninjaone.apps.rmm.controller.devices;

import com.ninjaone.rmm.devices.application.create.CreateDeviceInformationCommand;
import com.ninjaone.rmm.devices.domain.DeviceTypeAlreadyExistsException;
import com.ninjaone.shared.domain.DomainException;
import com.ninjaone.shared.domain.InvalidPriceException;
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
        dispatch(new CreateDeviceInformationCommand(id, request.type(), request.cost()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        HashMap<Class<? extends DomainException>, HttpStatus> errors = new HashMap<>();
        errors.put(DeviceTypeAlreadyExistsException.class, HttpStatus.CONFLICT);
        errors.put(InvalidPriceException.class, HttpStatus.BAD_REQUEST);

        return  errors;
    }
}

class DeviceRequest {

    private String type;
    private String cost;
    public DeviceRequest() {
    }

    public String type() {
        return type;
    }

    public String cost() {
        return cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
