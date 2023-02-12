package com.ninjaone.rmm.shared.domain;

import com.ninjaone.shared.domain.UuidMother;

public final class OrderIdMother {
    public static String random() {
        return UuidMother.random();
    }
}
