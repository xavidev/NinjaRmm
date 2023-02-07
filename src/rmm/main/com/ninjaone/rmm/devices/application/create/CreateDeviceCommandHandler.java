package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateDeviceCommandHandler implements CommandHandler<CreateDeviceCommand> {
    private final DeviceCreator creator;

    public CreateDeviceCommandHandler(DeviceCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateDeviceCommand command) {
        creator.create(command.id(), command.type(), command.cost());
    }
}
