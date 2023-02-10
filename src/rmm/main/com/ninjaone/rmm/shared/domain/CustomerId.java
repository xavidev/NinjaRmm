package com.ninjaone.rmm.shared.domain;

import com.ninjaone.shared.domain.UuidIdentifier;

public final class CustomerId extends UuidIdentifier {
    public CustomerId(String value) {
        super(value);
    }

    private CustomerId(){

    }
}
