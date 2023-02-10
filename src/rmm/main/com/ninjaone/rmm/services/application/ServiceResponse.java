package com.ninjaone.rmm.services.application;

import com.ninjaone.shared.domain.bus.query.Response;

public final class ServiceResponse implements Response {
    private String id;
    private double cost;
    private String name;

    public ServiceResponse(String id, double cost, String name) {
        this.id = id;
        this.cost = cost;
        this.name = name;
    }

    public double cost() {
        return cost;
    }

    public String name() {
        return name;
    }
}
