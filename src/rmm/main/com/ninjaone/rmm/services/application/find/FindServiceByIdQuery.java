package com.ninjaone.rmm.services.application.find;

import com.ninjaone.shared.domain.bus.query.Query;

public final class FindServiceByIdQuery implements Query {

    private final String id;

    public FindServiceByIdQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
