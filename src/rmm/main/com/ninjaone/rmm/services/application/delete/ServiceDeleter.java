package com.ninjaone.rmm.services.application.delete;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceId;

import java.util.Optional;

@com.ninjaone.shared.domain.Service
public final class ServiceDeleter {
    private final ServiceRepository repository;

    public ServiceDeleter(ServiceRepository repository) {
        this.repository = repository;
    }

    public void delete(String id) {
        Optional<ServiceInformation> service = repository.search(new ServiceId(id));

        if (service.isEmpty()) {
            return;
        }

        ServiceInformation toDelete = service.get();
        repository.delete(toDelete);
        toDelete.delete();
    }
}
