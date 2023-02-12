package com.ninjaone.rmmcustomers.customerdevcies.domain.model;

import com.ninjaone.shared.domain.UuidIdentifier;

public class CustomerId extends UuidIdentifier {
    public CustomerId(String value) {
        super(value);
    }

    protected CustomerId() {
    }
}
