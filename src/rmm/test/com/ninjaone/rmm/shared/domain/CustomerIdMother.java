package com.ninjaone.rmm.shared.domain;

import com.ninjaone.shared.domain.UuidMother;

public final class CustomerIdMother {
    public static String random() {
        return UuidMother.random();
    }
}
