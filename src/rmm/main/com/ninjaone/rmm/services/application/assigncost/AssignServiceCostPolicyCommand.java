package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.shared.domain.bus.command.Command;

public final class AssignServiceCostPolicyCommand implements Command {
    private final String serviceId;
    private final String policyType;
    private final String policyValue;

    public AssignServiceCostPolicyCommand(String serviceId, String policyType, String policyValue) {


        this.serviceId = serviceId;
        this.policyType = policyType;
        this.policyValue = policyValue;
    }

    public String serviceId() {
        return serviceId;
    }

    public String policyType() {
        return policyType;
    }

    public String policyValue() {
        return policyValue;
    }
}
