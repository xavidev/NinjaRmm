package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class AssignServiceCostPolicyCommandHandler implements CommandHandler<AssignServiceCostPolicyCommand> {
    private final ServiceCostPolicyAssigner costPolicyAssigner;

    public AssignServiceCostPolicyCommandHandler(ServiceCostPolicyAssigner costPolicyAssigner) {
        this.costPolicyAssigner = costPolicyAssigner;
    }

    @Override
    public void handle(AssignServiceCostPolicyCommand command) {
        costPolicyAssigner.assign(command.serviceId(), command.deviceType(), command.cost());
    }
}
