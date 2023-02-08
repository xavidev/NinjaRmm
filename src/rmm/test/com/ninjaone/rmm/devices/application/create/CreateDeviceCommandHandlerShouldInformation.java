package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.model.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateDeviceCommandHandlerShould extends DevicesModuleUnitTestCase {

    DeviceCreator subject;

    CreateDeviceCommandHandler handler;
    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new DeviceCreator(repository);
        handler = new CreateDeviceCommandHandler(subject);
    }

    @Test
    void create_new_device() {
        Device device = DeviceMother.Windows();

        handler.handle(new CreateDeviceCommand(device.id(), device.type(), device.cost()));

        shouldHaveSaved(device);
    }

}
