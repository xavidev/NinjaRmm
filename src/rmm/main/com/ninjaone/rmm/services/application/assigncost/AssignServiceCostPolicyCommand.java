package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.shared.domain.bus.command.Command;

public final class AssignServiceCostPolicyCommand implements Command {
    private String serviceId;
    private double cost;
    private String deviceType;

    public AssignServiceCostPolicyCommand(String serviceId, double cost, String deviceType) {

        this.serviceId = serviceId;
        this.cost = cost;
        this.deviceType = deviceType;
    }

    public String serviceId() {
        return serviceId;
    }

    public double cost() {
        return cost;
    }

    public String deviceType() {
        return deviceType;
    }
}
