package com.ninjaone.rmm.shared.domain;

public final class ForSameServiceCostPolicy extends ServiceCostPolicy {
    public ForSameServiceCostPolicy(String serviceName, String numOfServices, String discount) {
        super(serviceName, numOfServices, discount);
    }

    @Override
    public String type() {
        return "per_same_service";
    }
}
