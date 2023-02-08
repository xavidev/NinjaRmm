package com.ninjaone.rmm.devices.domain.model;

import java.util.Objects;

public final class DeviceInformation {
    private DeviceId id;
    private  DeviceType type;
    private  double cost;

    private DeviceInformation(DeviceId id, DeviceType type, double cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    private DeviceInformation(){

    }

    public static DeviceInformation create(String id, String type, double cost) {
        return new DeviceInformation(new DeviceId(id), new DeviceType(type), cost);
    }

    public String id() {
        return id.value();
    }

    public String type() {
        return type.value();
    }

    public double cost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceInformation deviceInformation = (DeviceInformation) o;
        return Objects.equals(id, deviceInformation.id) && Objects.equals(type, deviceInformation.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
