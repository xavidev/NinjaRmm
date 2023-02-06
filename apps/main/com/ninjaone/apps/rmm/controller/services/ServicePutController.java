package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.rmm.services.application.create.CreateServiceCommand;
import com.ninjaone.rmm.services.application.create.ServiceCreator;
import com.ninjaone.rmm.services.domain.DuplicateServiceException;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
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
public final class ServicePutController extends ApiController {


    public ServicePutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) {
        dispatch(new CreateServiceCommand(id, request.name(), request.cost()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        HashMap<Class<? extends DomainException>, HttpStatus> errors = new HashMap<>();
        errors.put(DuplicateServiceException.class, HttpStatus.CONFLICT);

        return errors;
    }
}

final class Request {
    private String name;

    private double cost;

    public String name() {
        return name;
    }

    public double cost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}


