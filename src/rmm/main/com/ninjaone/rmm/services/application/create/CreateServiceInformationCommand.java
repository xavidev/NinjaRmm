package com.ninjaone.rmm.services.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateServiceInformationCommand implements Command {
    private String id;
    private String name;
    private String cost;

    public CreateServiceInformationCommand(String id, String name, String cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public String cost() {
        return cost;
    }

    public String name() {
        return name;
    }

    public String id() {
        return id;
    }
}
