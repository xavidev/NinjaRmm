package com.ninjaone.rmm.services.domain.model;

import java.util.*;

public class Service {
    private ServiceId id;
    private ServiceName name;
    private double cost;
    private List<ServiceCostPolicy> costPolicies;

    private Service(ServiceId id, ServiceName name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.costPolicies = new ArrayList<>();
    }

    private Service() {

    }

    public static Service create(ServiceId id, ServiceName name, double cost) {
        return new Service(id, name, cost);
    }

    public void addCostPolicy(ServiceCostPolicy policy) {
        costPolicies.add(policy);
    }

    public String id() {
        return id.value();
    }

    public String name() {
        return name.value();
    }

    public double cost() {
        return cost;
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
