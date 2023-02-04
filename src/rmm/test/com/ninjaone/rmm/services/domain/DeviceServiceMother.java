package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.DeviceService;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceName;

public class DeviceServiceMother {
    public static DeviceService random() {
        return new DeviceService(
            new ServiceId("7cce24cd-832f-48af-8ebf-81c9e169bcfb"),
            new ServiceName("random service")
        );
    }
}
