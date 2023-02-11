package com.ninjaone.rmm.shared.domain;
public class PerDeviceTypeCostPolicy extends ServiceCostPolicy {

    public PerDeviceTypeCostPolicy(String device, String cost) {
        super(device, cost);
    }

    protected PerDeviceTypeCostPolicy() {

    }

    public static PerDeviceTypeCostPolicy create(String device, String cost) {
        return new PerDeviceTypeCostPolicy(device, cost);
    }

    public String cost() {
        return cost;
    }

    public String device() {
        return device;
    }

    public String type() {
        return "per_device";
    }
}

