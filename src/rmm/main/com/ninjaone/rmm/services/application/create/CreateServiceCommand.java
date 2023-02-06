package com.ninjaone.rmm.services.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateServiceCommand implements Command {
    private String id;
    private String name;
    private double cost;

    public CreateServiceCommand(String id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public double cost() {
        return cost;
    }

    public String name() {
        return name;
    }

    public String id() {
        return id;
    }
}
