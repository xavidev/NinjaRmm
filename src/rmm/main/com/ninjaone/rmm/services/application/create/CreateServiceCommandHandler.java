package com.ninjaone.rmm.services.application.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateServiceCommandHandler implements CommandHandler<CreateServiceInformationCommand> {
    private final ServiceCreator creator;

    public CreateServiceCommandHandler(ServiceCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateServiceInformationCommand command) {
        creator.create(command.id(), command.name(), command.cost());
    }
}
