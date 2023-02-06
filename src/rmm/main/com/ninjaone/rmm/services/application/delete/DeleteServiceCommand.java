package com.ninjaone.rmm.services.application.delete;

import com.ninjaone.shared.domain.bus.command.Command;

public final class DeleteServiceCommand implements Command {
    private String id;

    public DeleteServiceCommand(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
