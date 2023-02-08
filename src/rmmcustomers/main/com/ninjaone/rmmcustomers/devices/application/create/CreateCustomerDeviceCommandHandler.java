package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCustomerDeviceCommandHandler implements CommandHandler<CreateCustomerDeviceCommand> {
    private final CustomerDeviceCreator creator;

    public CreateCustomerDeviceCommandHandler(CustomerDeviceCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateCustomerDeviceCommand command) {
        creator.create(command.customerDeviceId(), command.deviceId(), command.customerId());
    }
}
