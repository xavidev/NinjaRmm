package com.ninjaone.rmm.services.domain.model;

import com.ninjaone.rmm.devices.domain.model.Device;

import java.util.*;

public class Service {
    private ServiceId id;
    private ServiceName name;
    private double cost;
    private Set<ServiceCostPolicy> costs;

    private Service(ServiceId id, ServiceName name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.costs = new HashSet<>();
    }

    private Service() {

    }

    public static Service create(ServiceId id, ServiceName name, double cost) {
        return new Service(id, name, cost);
    }

    public void addCostPolicy(String costId, double cost, String deviceType) {
        ServiceCostPolicy serviceCostPolicy = ServiceCostPolicy.create(costId, cost, deviceType);
        addCostPolicy(serviceCostPolicy);
    }

    public void addCostPolicy(ServiceCostPolicy serviceCostPolicy) {
        costs.add(serviceCostPolicy);
        serviceCostPolicy.assignTo(this);
    }

    public double costFor(Device device) {

        Optional<ServiceCostPolicy> deviceCost = costs
            .stream()
            .filter(cost -> cost.deviceType() != null)
            .filter(cost -> cost.deviceType().equals(device.type()))
            .findFirst();

        if (deviceCost.isPresent()) return deviceCost.get().cost();

        return cost();
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
