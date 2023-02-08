package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.shared.domain.bus.command.Command;

public final class CreateDeviceCommand implements Command {
    private String id;
    private String type;
    private double cost;

    public CreateDeviceCommand(String id, String type, double cost) {
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

    public double cost() {
        return cost;
    }
}