package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.rmmcustomers.customerdevcies.application.find.CustomerDeviceResponse;
import com.ninjaone.rmmcustomers.customerdevcies.application.find.FindCustomerDeviceQuery;
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
public final class CustomerDeviceGetController extends ApiController {
    public CustomerDeviceGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(path = "/devices/{id}/detail")
    public @ResponseBody ResponseEntity<CustomerDeviceResponse> index(
        @PathVariable String id,
        @RequestBody DeviceOrderRequest request) {
        CustomerDeviceResponse response = ask(new FindCustomerDeviceQuery(id, request.getCustomerId()));

        return new ResponseEntity<>(response, HttpStatus.OK);
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
