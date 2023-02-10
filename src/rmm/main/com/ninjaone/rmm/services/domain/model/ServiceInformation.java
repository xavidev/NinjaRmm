package com.ninjaone.rmm.services.domain.model;

import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.ServiceId;

import java.util.*;

public class ServiceInformation {
    private ServiceId id;
    private ServiceName name;
    private Price cost;
    private List<ServiceCostPolicy> costs;

    private ServiceInformation(ServiceId id, ServiceName name, Price cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.costs = new ArrayList<>();
    }

    private ServiceInformation() {

    }

    public static ServiceInformation create(ServiceId id, ServiceName name, Price cost) {
        return new ServiceInformation(id, name, cost);
    }

    public void addCostPolicy(ServiceCostPolicy policy) {
        costs.add(policy);
    }

    public String id() {
        return id.value();
    }

    public String name() {
        return name.value();
    }

    public Price cost() {
        return cost;
    }

    public Price costFor(String deviceType) {
        for (ServiceCostPolicy policy : costs) {
            if(policy.applyFor(deviceType)) {
                return new Price(policy.cost());
            }
        }

        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceInformation that = (ServiceInformation) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
