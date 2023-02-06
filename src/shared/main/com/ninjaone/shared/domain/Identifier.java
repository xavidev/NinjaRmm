package com.ninjaone.shared.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class Identifier implements Serializable {

    private String value;

    public Identifier(String value) {
        this.value = value;
    }

    private Identifier(){}

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
