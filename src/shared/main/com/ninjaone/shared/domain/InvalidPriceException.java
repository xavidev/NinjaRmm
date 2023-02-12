package com.ninjaone.shared.domain;

public final class InvalidPriceException extends DomainException {
    public InvalidPriceException(String value) {
        super("invalid_price", String.format("<%s> is not a valid BigDecimal value", value));
    }
}
