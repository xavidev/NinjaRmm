package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.rmm.shared.domain.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceName;
import com.ninjaone.rmm.shared.domain.UuidMother;

public class ServiceInformationMother {
    public static ServiceInformation random() {
        return ServiceInformation.create(
            new ServiceId(UuidMother.random()),
            new ServiceName("random service"),
            new Price("10")
        );
    }

    public static ServiceInformation antivirus(String cost) {
        return ServiceInformation.create(
            new ServiceId("7cce24cd-832f-48af-8ebf-81c9e169bcfb"),
            new ServiceName("antivirus"),
            new Price(cost)
        );
    }
}
