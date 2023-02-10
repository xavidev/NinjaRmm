package com.ninjaone.rmm.services.application.find;

import com.ninjaone.shared.domain.bus.query.Query;

import java.util.Objects;

public final class FindServiceByIdQuery implements Query {

    private final String id;

    public FindServiceByIdQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindServiceByIdQuery that = (FindServiceByIdQuery) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
