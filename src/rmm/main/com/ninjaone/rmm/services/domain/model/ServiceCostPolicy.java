package com.ninjaone.rmm.services.domain.model;

public class ServiceCostPolicy {
    private String deviceType;
    private double cost;
    private ServiceCostPolicy() {

    }

    private ServiceCostPolicy(double cost, String deviceType) {

        this.cost = cost;
        this.deviceType = deviceType;
    }

    public static ServiceCostPolicy create(double cost, String deviceType) {

        return new ServiceCostPolicy(cost, deviceType);
    }

    public String deviceType() {
        return deviceType;
    }

    public double cost() {
        return cost;
    }

    protected void setCost(double cost){
        this.cost =cost;
    }

    protected void setDeviceType(String deviceType){
        this.deviceType = deviceType;
    }
}
