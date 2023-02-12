package com.ninjaone.rmmcustomers.customerdevcies.application.create;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceMother;
import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.shared.domain.UuidMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class CustomerDeviceCreatorShould {

    private CustomerDeviceCreator subject;

    private CustomerDeviceRepository repository;
    @BeforeEach
    void setUp(){
        repository = mock(CustomerDeviceRepository.class);
        subject = new CustomerDeviceCreator(repository);
    }
    @Test
    void not_create_customer_device_if_exist_for_the_same_order(){
        var customerId = new CustomerDeviceId(UuidMother.random());
        var customerDevice =CustomerDeviceMother.random();

        when(repository.search(customerId)).thenReturn(
            Optional.of(
                customerDevice
            ));

        verify(repository, never()).save(customerDevice);

        subject.create(
            customerDevice.id().value(),
            customerDevice.customerId(),
            customerDevice.type().value());
    }
}
