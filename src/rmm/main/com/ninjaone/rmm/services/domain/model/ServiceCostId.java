package com.ninjaone.rmm.services.domain.model;

import com.ninjaone.shared.domain.UuidIdentifier;

public final class ServiceCostId  extends UuidIdentifier {
    public ServiceCostId(String value) {
        super(value);
    }

    private ServiceCostId() {
        super(null);
    }
}
