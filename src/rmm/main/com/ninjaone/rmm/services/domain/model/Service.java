package com.ninjaone.rmm.services.domain.model;

import java.util.Objects;

public class Service {
    private ServiceId id;
    private ServiceName name;

    public Service(ServiceId id, ServiceName name) {

        this.id = id;
        this.name = name;
    }

    private Service() {

    }

    public static Service create(ServiceId id, ServiceName name) {
        return new Service(id, name);
    }

    public String id() {
        return id.value();
    }

    public String name() {
        return name.value();
    }

    public double costFor(String deviceType) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service that = (Service) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
