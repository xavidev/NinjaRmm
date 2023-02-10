package com.ninjaone.rmm.shared.domain;

import com.ninjaone.shared.domain.UuidIdentifier;

public class ServiceId extends UuidIdentifier {
    public ServiceId(String id) {
        super(id);
    }

    private ServiceId() {
        super();
    }
}


