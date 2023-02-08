package com.ninjaone.rmm.costs.domain;

import com.ninjaone.rmm.services.application.ServiceInfoResponse;
import com.ninjaone.rmm.services.domain.model.CostPolicy;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public final class PriceCalculationFactory {

    private QueryBus bus;

    public PriceCalculationFactory(QueryBus bus) {
        this.bus = bus;
    }

    public static IPriceCalculationStrategy forService(ServiceInfoResponse info) {
        if(info.policy().equals(CostPolicy.PER_DEVICE.name())){
            return new PerDeviceTypeCalculationStrategy(info.policyMap());
        }else{
            return new FixedCostCalculationStrategy();
        }
    }
}
