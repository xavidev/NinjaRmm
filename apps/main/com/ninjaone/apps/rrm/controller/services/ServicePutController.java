package com.ninjaone.apps.rrm.controller.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ServicePutController {

    public ServicePutController() {

    }

    @PutMapping("/services/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) {

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

final class Request {
    private String name;
    private Price[] prices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price[] getPrices() {
        return prices;
    }

    public void setPrices(Price[] prices) {
        this.prices = prices;
    }
}

final class Price {
    private String dtype;
    private String price;

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

