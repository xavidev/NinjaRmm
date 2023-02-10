package com.ninjaone.rmm.bills.application.createbillexplanation;

import com.ninjaone.shared.domain.bus.query.QueryHandler;

public final class BillExplanationQueryHandler implements QueryHandler<BillExplanationQuery, BillExplanationResponse> {

    private final BillExplanationCreator creator;

    public BillExplanationQueryHandler(BillExplanationCreator creator) {
        this.creator = creator;
    }

    @Override
    public BillExplanationResponse handle(BillExplanationQuery query) {
        return creator.create(query.customerId());
    }
}
