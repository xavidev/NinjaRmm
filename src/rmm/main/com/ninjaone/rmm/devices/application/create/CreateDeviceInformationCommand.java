package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateDeviceInformationCommand implements Command {
    private String id;
    private String type;
    private String cost;

    public CreateDeviceInformationCommand(String id, String type, String cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public String id() {
        return id;
    }

    public String type() {
        return type;
    }

    public String cost() {
        return cost;
    }
}
