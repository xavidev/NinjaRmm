package com.ninjaone.rmm.services.application.delete;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class DeleteServiceCommandHandler implements CommandHandler<DeleteServiceCommand> {
    private final ServiceDeleter deleter;

    public DeleteServiceCommandHandler(ServiceDeleter deleter) {
        this.deleter = deleter;
    }

    @Override
    public void handle(DeleteServiceCommand command) {
        deleter.delete(command.id());
    }
}
