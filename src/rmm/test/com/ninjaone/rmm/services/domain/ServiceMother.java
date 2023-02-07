package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceName;
import com.ninjaone.rmm.shared.domain.UuidMother;

public class ServiceMother {
    public static Service random() {
        return Service.create(
            new ServiceId(UuidMother.random()),
            new ServiceName("random service"),
            10
        );
    }

    public static Service antivirus(int cost) {
        return Service.create(
            new ServiceId("7cce24cd-832f-48af-8ebf-81c9e169bcfb"),
            new ServiceName("antivirus"),
            cost
        );
    }
}
