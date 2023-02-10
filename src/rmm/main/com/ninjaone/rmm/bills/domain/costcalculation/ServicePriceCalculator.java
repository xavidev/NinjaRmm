package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.rmm.services.application.find.FindServiceByIdQuery;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public class ServicePriceCalculator {

    private final QueryBus queryBus;

    public ServicePriceCalculator(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    public Price priceFor(String customerId, String serviceId, String deviceId ) {

        ServiceResponse service = queryBus.ask(new FindServiceByIdQuery(serviceId));


//        return response.cost();
        return new Price("0");
    }
}
