package com.ninjaone.rmm.devices.application;

import com.ninjaone.shared.domain.bus.query.Response;

public final class DeviceResponse implements Response {
    private String type;
    private double cost;

    public DeviceResponse(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    public String type() {
        return type;
    }

    public double cost() {
        return cost;
    }
}
