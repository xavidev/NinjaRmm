package com.ninjaone.rmm.services.application.calculatecost;

import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.bus.query.Response;

public final class ServieCostResponse implements Response {
    private Price cost;

    public ServieCostResponse(Price cost) {

        this.cost = cost;
    }

    public Price cost(){
        return cost;
    }
}
