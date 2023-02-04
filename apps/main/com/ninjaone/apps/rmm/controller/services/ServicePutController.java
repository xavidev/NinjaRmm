package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.rmm.services.application.create.ServiceCreator;
import com.ninjaone.rmm.services.domain.DuplicateServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ServicePutController {

    private final ServiceCreator creator;

    public ServicePutController(ServiceCreator creator) {

        this.creator = creator;
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) {
        try {
            creator.create(id, request.name());
        } catch (DuplicateServiceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

final class Request {
    private String name;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


