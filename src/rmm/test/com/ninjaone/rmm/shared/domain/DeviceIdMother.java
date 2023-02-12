package com.ninjaone.rmm.shared.domain;

import com.ninjaone.shared.domain.UuidMother;

public final class DeviceIdMother {
    public static String random() {
        return UuidMother.random();
    }
}
