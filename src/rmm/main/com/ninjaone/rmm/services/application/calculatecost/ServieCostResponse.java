package com.ninjaone.rmm.services.application.calculatecost;

import com.ninjaone.shared.domain.bus.query.Response;

public final class ServieCostResponse implements Response {
    private double cost;

    public ServieCostResponse(double cost) {

        this.cost = cost;
    }

    public double cost(){
        return cost;
    }
}
