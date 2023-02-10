package com.ninjaone.apps.rmm.controller.orders;

import com.ninjaone.rmm.devices.domain.DeviceNotExistsException;
import com.ninjaone.rmm.orders.create.CreateServiceOrderCommand;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
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
public final class ServiceOrderPutController extends ApiController {
    public ServiceOrderPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(path = "/orders/{id}/service/{serviceId}")
    public @ResponseBody ResponseEntity<String> index(
        @PathVariable String serviceId,
        @PathVariable String id,
        @RequestBody ServiceRequest request) {

        dispatch(new CreateServiceOrderCommand(id, serviceId, request.getDeviceId(), request.getCustomerId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        HashMap<Class<? extends DomainException>, HttpStatus> errors = new HashMap<>();
        errors.put(ServiceNotExistException.class, HttpStatus.BAD_REQUEST);
        errors.put(DeviceNotExistsException.class, HttpStatus.BAD_REQUEST);

        return errors;
    }
}

@Data
class ServiceRequest {
    private String deviceId;
    private String customerId;
}
