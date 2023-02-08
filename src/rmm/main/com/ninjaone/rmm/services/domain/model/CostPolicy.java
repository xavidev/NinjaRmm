package com.ninjaone.rmm.services.domain.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.rmm.services.domain.InvalidCostPolicyException;

public enum CostPolicy {
    PER_DEVICE;

    public static ServiceCostPolicy makeFor(String policyType, String policyValue) {
        if(policyType.equals(PER_DEVICE.name())){
            ObjectMapper mapper = new ObjectMapper();
            PerDeviceInfo info = null;
            try {
                info = mapper.readValue(policyValue, PerDeviceInfo.class);
            } catch (JsonProcessingException e) {
                throw new InvalidCostPolicyException(policyValue);
            }

            return new PerDeviceTypeCostPolicy(info.type, info.cost);
        }
    }
}

class PerDeviceInfo {
    String type;
    double cost;
}
