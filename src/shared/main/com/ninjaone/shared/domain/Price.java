package com.ninjaone.shared.domain;

import java.math.BigDecimal;

public class Price extends BigDecimalValueObject {
    public Price(String value) {
        super(value);
    }

    protected Price(){
        super();
    }

    public Price plus(Price price){

        var newPrice = value().add(price.value());

        return new Price(String.valueOf(newPrice));
    }

    @Override
    public String toString() {
        return value().toString();
    }


}
