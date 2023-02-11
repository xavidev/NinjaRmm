package com.ninjaone.rmm.shared.domain;

public class PerSameServiceCostPolicy extends ServiceCostPolicy {
    public PerSameServiceCostPolicy(String serviceName, String numOfServices, String discount) {
        super(serviceName, numOfServices, discount);
    }

    protected PerSameServiceCostPolicy() {

    }

    @Override
    public String type() {
        return "per_same_service";
    }
}
