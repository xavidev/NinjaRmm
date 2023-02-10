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
        return new Price(price.value().add(price.value()).toString());
    }

    @Override
    public String toString() {
        return value().toString();
    }


}
