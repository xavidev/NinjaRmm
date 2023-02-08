package com.ninjaone.rmm.costs.domain;

import com.ninjaone.rmm.costs.domain.model.CustomerDevice;
import com.ninjaone.rmm.costs.domain.model.DeviceCost;
import com.ninjaone.rmm.services.application.FindServicesInformationQuery;
import com.ninjaone.rmm.services.application.ServiceInfoResponse;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryBus;

import java.util.ArrayList;
import java.util.List;

@Service
public final class DeviceCostCalulatorDomainService {
    private DeviceCost repository;
    private QueryBus bus;

    public DeviceCostCalulatorDomainService(DeviceCost repository, QueryBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public DeviceCost createCostFrom(CustomerDevice device) {
        List<ServiceInfoResponse> services = bus.ask(new FindServicesInformationQuery(device.services()));

        double cost = 0;
        List<CostDetail> detail = new ArrayList<>();

        for (ServiceInfoResponse info: services){
            IPriceCalculationStrategy strategy = PriceCalculationFactory.forService(info);
            cost += strategy.calculate();
        }

        return DeviceCost.create(device.id(), cost, detail);
    }
}
