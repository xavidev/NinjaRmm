package com.ninjaone.rmm.shared.domain;

public class PerDeviceTypeCostPolicy extends ServiceCostPolicy {

    public String type = CostPolicy.PER_DEVICE_TYPE.name();

    public PerDeviceTypeCostPolicy(String device, String cost) {
        super(device, cost);

        super.type = CostPolicy.PER_DEVICE_TYPE.name();
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
}

