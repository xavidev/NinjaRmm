package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceName;

public class ServiceMother {
    public static Service random() {
        return new Service(
            new ServiceId("7cce24cd-832f-48af-8ebf-81c9e169bcfb"),
            new ServiceName("random service")
        );
    }
}
