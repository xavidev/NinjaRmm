package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.shared.domain.bus.query.Query;

public final class FindDeviceByIdQuery implements Query {
    private final String aggregateId;

    public FindDeviceByIdQuery(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String deviceId() {
        return aggregateId;
    }
}
