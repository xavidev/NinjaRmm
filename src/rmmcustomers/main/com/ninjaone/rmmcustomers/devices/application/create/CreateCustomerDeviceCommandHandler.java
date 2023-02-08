package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.rmmcustomers.devices.domain.CustomerDeviceRepository;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;
import com.ninjaone.shared.domain.bus.event.EventBus;

@Service
public final class CreateCustomerDeviceCommandHandler implements CommandHandler<CreateCustomerDeviceCommand> {
    private final DeviceCreator creator;
    private final CustomerDeviceRepository repository;
    private final EventBus bus;

    public CreateCustomerDeviceCommandHandler(DeviceCreator creator, CustomerDeviceRepository repository, EventBus bus) {
        this.creator = creator;
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public void handle(CreateCustomerDeviceCommand command) {
        creator.create(command.deviceId(), command.customerId());
    }
}
