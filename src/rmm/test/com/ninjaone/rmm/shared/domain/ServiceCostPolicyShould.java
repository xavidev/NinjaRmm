package com.ninjaone.rmm.shared.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceCostPolicyShould {

    @BeforeEach
    void setUp() {
    }

    @Test
    void test_value() throws JsonProcessingException {
        var devicePolicy = ServiceCostPolicyMother.forDevice(DeviceInformationMother.Windows(), "50");

        assertEquals("{\"device\":\"Windows\",\"cost\":\"50\",\"type\":\"PER_DEVICE_TYPE\"}", devicePolicy.value());

        var perServicePolicy = ServiceCostPolicyMother.forSameServices("antivirus", "3", "50");

        assertEquals("{\"serviceName\":\"antivirus\",\"numOfServices\":\"3\",\"discount\":\"50\",\"type\":\"PER_SAME_SERVICE\"}", perServicePolicy.value());
    }
}
