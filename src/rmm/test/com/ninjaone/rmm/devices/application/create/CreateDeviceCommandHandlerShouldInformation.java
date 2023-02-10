package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateDeviceCommandHandlerShouldInformation extends DevicesModuleUnitTestCase {

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
        DeviceInformation deviceInformation = DeviceMother.Windows();

        handler.handle(new CreateDeviceCommand(deviceInformation.id(), deviceInformation.type(), deviceInformation.cost().toString()));

        shouldHaveSaved(deviceInformation);
    }

}
