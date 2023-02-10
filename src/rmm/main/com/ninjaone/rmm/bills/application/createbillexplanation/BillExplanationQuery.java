package com.ninjaone.rmm.bills.application.createbillexplanation;

import com.ninjaone.shared.domain.bus.query.Query;

public final class BillExplanationQuery implements Query {
    private final String customerId;

    public BillExplanationQuery(String customerId) {
        this.customerId = customerId;
    }

    public String customerId() {
        return customerId;
    }
}
