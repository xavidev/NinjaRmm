package com.ninjaone.rmm.services.application;

import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.bus.query.Response;

public final class ServiceResponse implements Response {
    private String id;
    private Price cost;
    private String name;

    public ServiceResponse(String id, Price cost, String name) {
        this.id = id;
        this.cost = cost;
        this.name = name;
    }

    public Price cost() {
        return cost;
    }

    public String name() {
        return name;
    }
}
