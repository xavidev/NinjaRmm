package com.ninjaone.rmm.devices.application.create;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.model.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeviceCreatorShould extends DevicesModuleUnitTestCase {

    DeviceCreator subject;
    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new DeviceCreator(repository);
    }

    @Test
    void create_new_device() {
        Device device = DeviceMother.Windows();

        subject.create(device.id(), device.type());

        shouldHaveSaved(device);
    }

}
