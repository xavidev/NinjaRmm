package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateDeviceInformationCommandHandlerShould extends DevicesModuleUnitTestCase {

    DeviceCreator subject;

    CreateDeviceInformationCommandHandler handler;
    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new DeviceCreator(repository);
        handler = new CreateDeviceInformationCommandHandler(subject);
    }

    @Test
    void create_new_device() {
        DeviceInformation deviceInformation = DeviceInformationMother.Windows();

        handler.handle(new CreateDeviceInformationCommand(deviceInformation.id(), deviceInformation.type(), deviceInformation.cost().toString()));

        shouldHaveSaved(deviceInformation);
    }

}
