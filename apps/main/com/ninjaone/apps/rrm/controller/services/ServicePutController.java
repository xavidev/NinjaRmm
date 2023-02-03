package com.ninjaone.apps.rrm.controller.services;

import com.ninjaone.rmm.services.application.create.ServiceCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ServicePutController {

    private ServiceCreator creator;

    public ServicePutController(ServiceCreator creator) {

        this.creator = creator;
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) {

        creator.create(id, request.name());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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


