package com.ninjaone.rmm.orders.domain.model;

import com.ninjaone.shared.domain.StringValue;

public final class OrderName extends StringValue {
    public OrderName(String value) {
        super(value);
    }

    private OrderName(){
        super("");

    }
}
