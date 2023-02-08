package com.ninjaone.rmm.services.application;

import java.util.List;

public final class ServiceResponse {
    private String id;
    private double cost;

    private List<ServiceCostPolicyResponse> costPolicies;

    public ServiceResponse(String id, double cost, List<ServiceCostPolicyResponse> costPolicies) {
        this.id = id;
        this.cost = cost;
        this.costPolicies = costPolicies;
    }
}
