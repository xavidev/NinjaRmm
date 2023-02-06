package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.shared.domain.bus.query.Query;

public final class FindDeviceByCriteriaQuery implements Query {
    private String type;

    public FindDeviceByCriteriaQuery(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
