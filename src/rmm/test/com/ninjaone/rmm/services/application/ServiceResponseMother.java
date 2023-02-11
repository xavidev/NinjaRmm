package com.ninjaone.rmm.services.application;

import com.ninjaone.rmm.services.domain.model.ServiceInformation;

public class ServiceResponseMother {
    public static ServiceResponse fromService(ServiceInformation service) {
        return new ServiceResponse(service);
    }
}
