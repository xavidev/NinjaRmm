package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.shared.domain.bus.command.CommandHandler;

public final class AssignServiceCostPolicyCommandHandler implements CommandHandler<AssignServiceCostPolicyCommand> {
    private final ServiceCostPolicyAssigner costPolicyAssigner;

    public AssignServiceCostPolicyCommandHandler(ServiceCostPolicyAssigner costPolicyAssigner) {
        this.costPolicyAssigner = costPolicyAssigner;
    }

    @Override
    public void handle(AssignServiceCostPolicyCommand command) {
        costPolicyAssigner.assign(command.serviceId(), command.cost(), command.deviceType());
    }
}
