package com.ninjaone.rmm.devices.domain.model;

import java.util.Objects;

public final class Device {
    private final DeviceId id;
    private final DeviceType type;
    private final double cost;

    private Device(DeviceId id, DeviceType type, double cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public static Device create(String id, String type, double cost) {
        return new Device(new DeviceId(id), new DeviceType(type), cost);
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
        Device device = (Device) o;
        return Objects.equals(id, device.id) && Objects.equals(type, device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public void delete() {

    }
}
