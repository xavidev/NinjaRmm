package com.ninjaone.rmm.costs.domain;

import com.ninjaone.rmm.costs.domain.model.CostPolicy;

public class CostPolicyMother {



    public static CostPolicy randomFor(String serviceId) {
        return new CostPolicy("24109e93-32bd-41d6-8a74-06747188a721", serviceId, 10, "device", "MAC");
    }
}
