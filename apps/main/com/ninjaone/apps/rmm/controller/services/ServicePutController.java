package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.rmm.services.application.create.CreateServiceInformationCommand;
import com.ninjaone.rmm.services.domain.DuplicateServiceException;
import com.ninjaone.shared.domain.DomainException;
import com.ninjaone.shared.domain.InvalidPriceException;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class ServicePutController extends ApiController {


    public ServicePutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody ServiceRequest request) {
        dispatch(new CreateServiceInformationCommand(id, request.getName(), request.getCost()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        HashMap<Class<? extends DomainException>, HttpStatus> errors = new HashMap<>();
        errors.put(DuplicateServiceException.class, HttpStatus.CONFLICT);
        errors.put(InvalidPriceException.class, HttpStatus.BAD_REQUEST);

        return errors;
    }
}
@Data
final class ServiceRequest {
    private String name;

    private String cost;
}


