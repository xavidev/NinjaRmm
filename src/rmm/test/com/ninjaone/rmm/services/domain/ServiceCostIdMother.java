package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.costs.domain.model.ServiceCostId;
import com.ninjaone.rmm.shared.domain.UuidMother;

public final class ServiceCostIdMother {
    public static ServiceCostId random() {
        return new ServiceCostId(UuidMother.random());
    }
}
