package com.ninjaone.rmm.services.domain.model;

import java.util.Objects;

public class DeviceService {
    private ServiceId id;
    private ServiceName name;

    public DeviceService(ServiceId id, ServiceName name) {

        this.id = id;
        this.name = name;
    }

    public static DeviceService create(ServiceId id, ServiceName name) {
        return new DeviceService(id, name);
    }

    public String id() {
        return id.value();
    }

    public String name() {
        return name.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceService that = (DeviceService) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
