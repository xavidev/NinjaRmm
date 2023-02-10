package com.ninjaone.rmm.devices.domain.model;

import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.domain.Price;

import java.util.Objects;

public final class DeviceInformation {
    private DeviceId id;
    private  DeviceType type;
    private Price cost;

    private DeviceInformation(DeviceId id, DeviceType type, Price cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    private DeviceInformation(){

    }

    public static DeviceInformation create(String id, String type, String cost) {
        return new DeviceInformation(new DeviceId(id), new DeviceType(type), new Price(cost));
    }

    public String id() {
        return id.value();
    }

    public String type() {
        return type.value();
    }

    public Price cost() {
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
