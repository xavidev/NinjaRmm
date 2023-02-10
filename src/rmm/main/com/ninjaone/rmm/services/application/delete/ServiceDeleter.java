package com.ninjaone.rmm.services.application.delete;

import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.ServiceId;

import java.util.Optional;

@com.ninjaone.shared.domain.Service
public final class ServiceDeleter {
    private final ServiceInformationRepository repository;

    public ServiceDeleter(ServiceInformationRepository repository) {
        this.repository = repository;
    }

    public void delete(String id) {
        Optional<ServiceInformation> service = repository.search(new ServiceId(id));

        if (service.isEmpty()) {
            return;
        }

        ServiceInformation toDelete = service.get();
        repository.delete(toDelete);
    }
}
