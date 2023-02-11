package com.ninjaone.rmm.services.application.assigncost;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.rmm.services.domain.InvalidCostPolicyException;
import com.ninjaone.rmm.services.domain.MalFormedCostPolicyException;
import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.*;


@com.ninjaone.shared.domain.Service
public final class ServiceCostPolicyAssigner {
    private final ServiceInformationRepository serviceInformationRepository;

    public ServiceCostPolicyAssigner(ServiceInformationRepository serviceInformationRepository) {
        this.serviceInformationRepository = serviceInformationRepository;
    }

    public void assign(String serviceId, String policyType, String policyValue) {
        ServiceInformation serviceInformation = serviceInformationRepository.search(new ServiceId(serviceId)).
            orElseThrow(() -> new ServiceNotExistException(new ServiceId(serviceId)));

        var factory = new PolicyFactory();

        serviceInformation.addCostPolicy(factory.makeFor(policyType, policyValue));

        serviceInformationRepository.save(serviceInformation);
    }
}


class PolicyFactory {
    ObjectMapper mapper;
    public PolicyFactory() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public ServiceCostPolicy makeFor(String policyType, String value) {
        ServiceCostPolicy policy;

        try {
            if (policyType.equals(CostPolicy.PER_DEVICE_TYPE.name())) {
                policy = mapper.readValue(value, PerDeviceTypeCostPolicy.class);

                return policy;
            }

            if (policyType.equals(CostPolicy.PER_SAME_SERVICE.name())) {
                policy = mapper.readValue(value, PerSameServiceCostPolicy.class);

                return policy;
            }

        } catch (JsonProcessingException ex) {
            throw new MalFormedCostPolicyException(value);
        }

        throw new InvalidCostPolicyException(policyType);
    }
}
