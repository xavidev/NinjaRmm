package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.shared.domain.bus.query.Query;

import java.util.Objects;

public final class FindDeviceByIdQuery implements Query {
    private final String aggregateId;

    public FindDeviceByIdQuery(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String deviceId() {
        return aggregateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindDeviceByIdQuery that = (FindDeviceByIdQuery) o;
        return Objects.equals(aggregateId, that.aggregateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggregateId);
    }
}
