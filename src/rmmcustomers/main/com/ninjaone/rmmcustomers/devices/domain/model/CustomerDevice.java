package com.ninjaone.rmmcustomers.devices.domain.model;

public final class CustomerDevice {
    private String id;
    private double cost;
    private String systemName;

    public CustomerDevice(String id, double cost, String systemName) {
        this.id = id;
        this.cost = cost;
        this.systemName = systemName;
    }
}
