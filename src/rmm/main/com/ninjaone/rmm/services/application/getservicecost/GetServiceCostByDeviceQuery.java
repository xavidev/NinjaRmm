package com.ninjaone.rmm.services.application.getservicecost;

import com.ninjaone.shared.domain.bus.query.Query;

public final class GetServiceCostByDeviceQuery implements Query {
    private String id;
    private String deviceType;

    public GetServiceCostByDeviceQuery(String id, String deviceType) {

        this.id = id;
        this.deviceType = deviceType;
    }

    public String id(){
        return id;
    }

    public String deviceType(){
        return deviceType;
    }
}
