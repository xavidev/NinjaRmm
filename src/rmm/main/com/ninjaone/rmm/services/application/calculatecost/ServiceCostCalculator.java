package com.ninjaone.rmm.services.application.calculatecost;

import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.domain.criteria.Filter;

import java.util.ArrayList;
import java.util.List;

@com.ninjaone.shared.domain.Service
public final class ServiceCostCalculator {
    private final ServiceRepository repository;

    public ServiceCostCalculator(ServiceRepository repository, ) {
        this.repository = repository;
    }

    public double calculate(String devicetype, String serviceId) {
        List<Filter> filters = new ArrayList<>();

        ServiceInformation serviceInformation = repository.search(new ServiceId(serviceId))
            .orElseThrow(() -> new ServiceNotExistException(new ServiceId(serviceId)));

        return serviceInformation.costFor(devicetype);
    }
}
