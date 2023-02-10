package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateDeviceInformationCommandHandler implements CommandHandler<CreateDeviceInformationCommand> {
    private final DeviceCreator creator;

    public CreateDeviceInformationCommandHandler(DeviceCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateDeviceInformationCommand command) {
        creator.create(command.id(), command.type(), command.cost());
    }
}
