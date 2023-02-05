package com.ninjaone.rmm.services.domain.model;

import java.util.*;

public class Service {
    private ServiceId id;
    private ServiceName name;
    private Set<ServiceCost> costs;

    public Service(ServiceId id, ServiceName name) {
        this.id = id;
        this.name = name;
        this.costs = new HashSet<>();
    }

    private Service() {

    }

    public static Service create(ServiceId id, ServiceName name) {
        return new Service(id, name);
    }

    public void addCost(String costId, double cost, String deviceType) {
        ServiceCost serviceCost = ServiceCost.create(costId, cost, deviceType);
        addCost(serviceCost);
    }

    private void addCost(ServiceCost serviceCost) {
        costs.add(serviceCost);
        serviceCost.assignTo(this);
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
        Service that = (Service) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
