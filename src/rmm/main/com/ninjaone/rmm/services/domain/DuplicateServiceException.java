package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.ServiceName;
import com.ninjaone.shared.domain.DomainException;

public class DuplicateServiceException extends DomainException {
    public DuplicateServiceException(ServiceName name) {
        super("duplicate_service", String.format("The service <%s> already exist.", name.value()));
    }
}
