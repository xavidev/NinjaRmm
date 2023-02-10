package com.ninjaone.rmm.services.application.find;

import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.rmm.shared.domain.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.shared.domain.Service;

@Service
public final class ServiceFinder {
    private final ServiceInformationRepository repository;

    public ServiceFinder(ServiceInformationRepository repository) {
        this.repository = repository;
    }

    public ServiceResponse find(String id) {
        ServiceInformation service = repository.search(new ServiceId(id))
            .orElseThrow(() -> new ServiceNotExistException(new ServiceId(id)));

        return new ServiceResponse(service.id(), service.cost(), service.name());
    }
}
