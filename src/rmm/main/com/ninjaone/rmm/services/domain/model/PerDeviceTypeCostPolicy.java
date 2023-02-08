package com.ninjaone.rmm.services.domain.model;

public final class PerDeviceTypeCostPolicy extends ServiceCostPolicy {
    private String deviceType;
    private double cost;

    public PerDeviceTypeCostPolicy(String deviceType, double cost) {
        super(CostPolicy.PER_DEVICE.name());
        this.deviceType = deviceType;
        this.cost = cost;
    }

    private PerDeviceTypeCostPolicy(){}

    public boolean applicableFor(String deviceType){
        return this.deviceType.equals(deviceType);
    }

    public double cost(){
        return this.cost;
    }
}
