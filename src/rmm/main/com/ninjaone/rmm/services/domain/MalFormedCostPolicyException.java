package com.ninjaone.rmm.services.domain;

import com.ninjaone.shared.domain.DomainException;

public final class MalFormedCostPolicyException extends DomainException {

    public MalFormedCostPolicyException(String policyValue) {
        super("mal_formed_cost_policy", String.format("The policy value: <%s> is mal formed.", policyValue));
    }
}
