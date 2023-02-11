package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.shared.domain.bus.command.Command;

public final class AssignServiceCostPolicyCommand implements Command {
    private final String serviceId;
    private final String policyType;
    private final String cost;

    public AssignServiceCostPolicyCommand(String serviceId, String type, String value) {


        this.serviceId = serviceId;
        this.policyType = type;
        this.cost = value;
    }

    public String serviceId() {
        return serviceId;
    }

    public String policyType() {
        return policyType;
    }

    public String policyValue() {
        return cost;
    }
}
