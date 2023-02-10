package com.ninjaone.rmm.services.application.calculatecost;

import com.ninjaone.shared.domain.bus.query.Query;

public final class GetServiceCostQuery implements Query {
    private String serviceId;
    private String deviceId;

    public GetServiceCostQuery(String serviceId, String deviceId) {
        this.serviceId = serviceId;
        this.deviceId = deviceId;
    }

    public String serviceId(){
        return serviceId;
    }

    public String deviceId() {
        return null;
    }
}
