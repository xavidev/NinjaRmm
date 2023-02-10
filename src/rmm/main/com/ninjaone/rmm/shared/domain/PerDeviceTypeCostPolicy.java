package com.ninjaone.rmm.shared.domain;
public class PerDeviceTypeCostPolicy extends ServiceCostPolicy {

    public PerDeviceTypeCostPolicy(String device, String cost) {
        super(device, cost);
    }

    public static PerDeviceTypeCostPolicy create(String deviceType, String cost) {
        return new PerDeviceTypeCostPolicy(deviceType, cost);
    }

    public String cost() {
        return cost;
    }

    public String type() {
        return "per_device";
    }
}

