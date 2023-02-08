package com.ninjaone.rmmcustomers.services.application.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCustomerServiceCommandHandler implements CommandHandler<CreateCustomerServiceCommand> {
    private final CustomerServiceCreator creator;


    public CreateCustomerServiceCommandHandler(CustomerServiceCreator creator) {

        this.creator = creator;
    }

    @Override
    public void handle(CreateCustomerServiceCommand command) {
        creator.create(command.serviceId(), command.deviceId(), command.customerId());
    }
}
