package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.shared.domain.bus.command.Command;

public final class AssignServiceCostPolicyCommand implements Command {
    private final String serviceId;
    private final String policyType;
    private final double cost;

    public AssignServiceCostPolicyCommand(String serviceId, String deviceType, double cost) {


        this.serviceId = serviceId;
        this.policyType = deviceType;
        this.cost = cost;
    }

    public String serviceId() {
        return serviceId;
    }

    public String deviceType() {
        return policyType;
    }

    public double cost() {
        return cost;
    }
}
