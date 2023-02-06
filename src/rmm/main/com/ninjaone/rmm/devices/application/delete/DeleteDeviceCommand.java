package com.ninjaone.rmm.devices.application.delete;

import com.ninjaone.shared.domain.bus.command.Command;

public final class DeleteDeviceCommand implements Command {
    private String id;

    public DeleteDeviceCommand(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
