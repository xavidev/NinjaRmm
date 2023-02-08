package com.ninjaone.rmm.devices.application;

import com.ninjaone.shared.domain.bus.query.Query;

public final class FindDeviceByIdQuery implements Query {
    private final String deviceId;

    public FindDeviceByIdQuery(String deviceId){
        this.deviceId = deviceId;
    }

    public String deviceId() {
        return this.deviceId;
    }
}
