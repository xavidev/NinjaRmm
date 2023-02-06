package com.ninjaone.rmm.devices.domain.model;

import java.util.Objects;

public final class Device {
    private final DeviceId id;
    private final DeviceType type;

    private Device(DeviceId id, DeviceType type) {
        this.id = id;
        this.type = type;
    }

    public static Device create(String id, String type) {
        return new Device(new DeviceId(id), new DeviceType(type));
    }

    public String id() {
        return id.value();
    }

    public String type() {
        return id.value();
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
}
