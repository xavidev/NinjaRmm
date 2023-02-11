package com.ninjaone.rmm.services.application;

import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.bus.query.Response;

import java.util.List;
import java.util.Map;

public final class ServiceResponse implements Response {
    private final List<Map.Entry<String, String>> costPolicies;
    private String id;
    private Price cost;
    private String name;

    public ServiceResponse(ServiceInformation info) {
        this.id = info.id();
        this.cost = info.cost();
        this.name = info.name();
        this.costPolicies = info.costPolicies();
    }


    public Price cost() {
        return cost;
    }

    public String name() {
        return name;
    }

    public List<Map.Entry<String, String>> policies() {
        return costPolicies;
    }
}
