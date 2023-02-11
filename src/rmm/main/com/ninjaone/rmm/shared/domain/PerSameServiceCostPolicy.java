package com.ninjaone.rmm.shared.domain;

public class PerSameServiceCostPolicy extends ServiceCostPolicy {

    public String type = CostPolicy.PER_SAME_SERVICE.name();
    public PerSameServiceCostPolicy(String serviceName, String numOfServices, String discount) {
        super(serviceName, numOfServices, discount);

        super.type = CostPolicy.PER_SAME_SERVICE.name();
    }

    protected PerSameServiceCostPolicy() {

    }
}
