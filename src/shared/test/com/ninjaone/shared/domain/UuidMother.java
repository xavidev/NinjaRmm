package com.ninjaone.shared.domain;

import java.util.UUID;

public final class UuidMother {

    public static String random() {
        return UUID.randomUUID().toString();
    }
}
