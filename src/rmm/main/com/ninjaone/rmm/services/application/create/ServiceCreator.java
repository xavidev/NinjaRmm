package com.ninjaone.rmm.services.application.create;


import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.DuplicateServiceException;
import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceName;
import com.ninjaone.shared.domain.criteria.*;

import java.util.ArrayList;
import java.util.List;

@com.ninjaone.shared.domain.Service
public final class ServiceCreator {

    private final ServiceRepository repository;

    public ServiceCreator(ServiceRepository repository) {

        this.repository = repository;
    }

    public void create(String id, String name, double cost) {

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.create("name", FilterOperator.EQUAL.value(), name));

        if(!repository.matching(new Criteria(new Filters(filters), Order.none())).isEmpty()){
          throw new DuplicateServiceException(new ServiceName(name));
        }

        var service = Service.create(new ServiceId(id), new ServiceName(name), cost);

        repository.save(service);
    }
}
