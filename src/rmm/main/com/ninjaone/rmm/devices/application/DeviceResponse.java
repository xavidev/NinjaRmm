package com.ninjaone.rmm.devices.application;

import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.bus.query.Response;

public final class DeviceResponse implements Response {
    private String id;
    private String type;
    private Price cost;

    public DeviceResponse(String id, String type, Price cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public String type() {
        return type;
    }

    public Price cost() {
        return cost;
    }

    public String id() {
        return id;
    }
}
