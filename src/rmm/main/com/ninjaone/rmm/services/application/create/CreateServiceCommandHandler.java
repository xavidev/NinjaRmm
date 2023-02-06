package com.ninjaone.rmm.services.application.create;

import com.ninjaone.shared.domain.bus.command.CommandHandler;

public final class CreateServiceCommandHandler implements CommandHandler<CreateServiceCommand> {
    private final ServiceCreator creator;

    public CreateServiceCommandHandler(ServiceCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateServiceCommand command) {
        creator.create(command.id(), command.name(), command.cost());
    }
}
