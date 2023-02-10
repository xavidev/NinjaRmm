package com.ninjaone.rmm.bills.application.createbillexplanation;

import com.ninjaone.shared.domain.bus.query.Response;

public final class BillExplanationResponse implements Response {
    private String billExplanation;

    public BillExplanationResponse(String billExplanation) {

        this.billExplanation = billExplanation;
    }
}
