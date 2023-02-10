package com.ninjaone.shared.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class BigDecimalValueObject {
    private final BigDecimal value;

    public BigDecimalValueObject(String value) {
        this.value = new BigDecimal(value);
    }

    protected BigDecimalValueObject(){
        value = new BigDecimal("0");
    }

    public BigDecimal value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigDecimalValueObject that = (BigDecimalValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
