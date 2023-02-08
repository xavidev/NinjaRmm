package com.ninjaone.rmm.services.domain;

import com.ninjaone.shared.domain.DomainException;

public final class InvalidCostPolicyException extends DomainException {
    public InvalidCostPolicyException(String policyValue) {
        super("invalid_cost_policy", String.format("The policy <%s> is invalid.", policyValue));
    }
}
