package com.ninjaone.rmm.costs.domain.model;

public final class DeviceCost {
    private DeviceCostId id;

    public DeviceCost(DeviceCostId id) {
        this.id = id;
    }

    private DeviceCost(){

    }

    public String id() {
        return id.value();
    }
}
