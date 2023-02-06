package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.ServiceCost;

public final class ServiceCostMother {

    public static ServiceCost random() {
        return ServiceCost.create(ServiceCostIdMother.random().value(), 10, "WIN");
    }
}
