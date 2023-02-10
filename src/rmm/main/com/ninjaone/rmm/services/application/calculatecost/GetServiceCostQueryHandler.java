package com.ninjaone.rmm.services.application.calculatecost;

import com.ninjaone.shared.domain.bus.query.QueryHandler;

public final class GetServiceCostQueryHandler implements QueryHandler<GetServiceCostQuery, ServieCostResponse> {
    private final ServiceCostCalculator calculator;

    public GetServiceCostQueryHandler(ServiceCostCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public ServieCostResponse handle(GetServiceCostQuery query) {
        return calculator.costFor(query.serviceId(), query.deviceId());
    }
}
