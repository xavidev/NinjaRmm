package com.ninjaone.rmm.orders.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateServiceOrderCommandHandler implements CommandHandler<CreateServiceOrderCommand> {
    private final ServiceOrderCreator creator;


    public CreateServiceOrderCommandHandler(ServiceOrderCreator creator) {

        this.creator = creator;
    }

    @Override
    public void handle(CreateServiceOrderCommand command) {
        creator.create(command.customerServiceId(), command.serviceId(), command.deviceId(), command.customerId());
    }
}
