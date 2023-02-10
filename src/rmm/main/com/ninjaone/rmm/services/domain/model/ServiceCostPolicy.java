package com.ninjaone.rmm.services.domain.model;

public class ServiceCostPolicy {

    private String device;
    private String cost;

    private ServiceCostPolicy(String device, String cost) {
        this.device = device;
        this.cost = cost;
    }

    protected ServiceCostPolicy(){

    }

    public static ServiceCostPolicy create(String deviceType, String cost) {
        return new ServiceCostPolicy(deviceType, cost);
    }

    public String cost() {
        return cost;
    }

    public boolean applyFor(String device) {
        return this.device.equals(device);
    }
}

