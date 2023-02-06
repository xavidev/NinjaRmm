package com.ninjaone.rmm.devices.application;

import com.ninjaone.shared.domain.bus.query.Response;

public final class DeviceResponse implements Response {
    private String type;

    public DeviceResponse(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
