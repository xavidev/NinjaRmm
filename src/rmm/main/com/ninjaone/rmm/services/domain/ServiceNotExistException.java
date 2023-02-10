package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.shared.domain.ServiceId;
import com.ninjaone.shared.domain.DomainException;

public final class ServiceNotExistException extends DomainException {
    public ServiceNotExistException(ServiceId id) {
        super("service_not_exist", String.format("The service <%s> doesn't exist", id.value()));
    }
}
