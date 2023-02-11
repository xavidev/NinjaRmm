package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.rmm.services.application.find.FindServiceByIdQuery;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryBus;

import java.util.List;


@Service
public class ServicePriceCalculator {
    private final QueryBus queryBus;
    private List<CalculationStrategy> strategies;

    public ServicePriceCalculator(QueryBus queryBus, List<CalculationStrategy> strategies) {
        this.queryBus = queryBus;
        this.strategies = strategies;
    }

    public Price priceFor(String customerId, String serviceId, String deviceId, String type) {

        ServiceResponse service = queryBus.ask(new FindServiceByIdQuery(serviceId));

        Price price = service.cost();
        for (CalculationStrategy strategy: strategies) {
            price = strategy.calculate(
                price,
                service.policies(),
                new CalculationParams(customerId, serviceId, deviceId, type));
        }

        return price;
    }
}
