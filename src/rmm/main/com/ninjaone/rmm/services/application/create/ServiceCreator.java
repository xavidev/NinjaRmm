package com.ninjaone.rmm.services.application.create;

import com.ninjaone.rmm.services.application.find.FindCriteria;
import com.ninjaone.rmm.services.domain.DuplicateServiceException;
import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceName;

@com.ninjaone.shared.domain.Service
public final class ServiceCreator {

    private final ServiceInformationRepository repository;

    public ServiceCreator(ServiceInformationRepository repository) {

        this.repository = repository;
    }

    public void create(String id, String name, String cost) {
        if (!repository.matching(FindCriteria.byName(name)).isEmpty()) {
            throw new DuplicateServiceException(new ServiceName(name));
        }

        var service = ServiceInformation.create(new ServiceId(id), new ServiceName(name), new Price(cost));

        repository.save(service);
    }
}
