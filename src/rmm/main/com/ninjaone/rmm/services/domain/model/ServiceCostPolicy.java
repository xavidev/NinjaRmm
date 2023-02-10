package com.ninjaone.rmm.services.domain.model;

public class ServiceCostPolicy {

    private String device;
    private double cost;

    private ServiceCostPolicy(String device, double cost) {
        this.device = device;
        this.cost = cost;
    }

    protected ServiceCostPolicy(){

    }

    public static ServiceCostPolicy create(String deviceType, double cost) {
        return new ServiceCostPolicy(deviceType, cost);
    }

    public double cost() {
        return cost;
    }

    public boolean applyFor(String device) {
        return this.device.equals(device);
    }
}

