package com.ninjaone.shared.domain;

import java.util.UUID;

public abstract class UuidIdentifier extends Identifier {
    public UuidIdentifier(String value) {
        super(value);

        ensureValidUuid(value);
    }

    protected UuidIdentifier(){
        super(null);
    }

    private void ensureValidUuid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }
}
