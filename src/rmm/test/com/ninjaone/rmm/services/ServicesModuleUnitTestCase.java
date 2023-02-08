package com.ninjaone.rmm.services;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ServicesModuleUnitTestCase extends UnitTestCase {
    protected ServiceRepository serviceRepository;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        serviceRepository = mock(ServiceRepository.class);
    }

    public void shouldHaveSaved(ServiceInformation serviceInformation) {
        verify(serviceRepository, atLeastOnce()).save(serviceInformation);
    }

    public void shouldNotSave(ServiceInformation serviceInformation) {
        verify(serviceRepository, never()).save(serviceInformation);
    }

    public void shouldSearch(ServiceInformation serviceInformation) {
        Mockito.when(serviceRepository.search(new ServiceId(serviceInformation.id()))).thenReturn(Optional.of(serviceInformation));
    }

    protected void shouldDelete(ServiceInformation serviceInformation) {
        verify(serviceRepository, atLeastOnce()).delete(serviceInformation);
    }

    protected void shouldNotDelete(ServiceInformation serviceInformation) {
        verify(serviceRepository, never()).delete(serviceInformation);
    }
}
