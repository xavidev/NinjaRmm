package com.ninjaone.rmm.services;

import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.ServiceId;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ServicesModuleUnitTestCase extends UnitTestCase {
    protected ServiceInformationRepository serviceInformationRepository;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        serviceInformationRepository = mock(ServiceInformationRepository.class);
    }

    public void shouldHaveSaved(ServiceInformation serviceInformation) {
        verify(serviceInformationRepository, atLeastOnce()).save(serviceInformation);
    }

    public void shouldNotSave(ServiceInformation serviceInformation) {
        verify(serviceInformationRepository, never()).save(serviceInformation);
    }

    public void shouldSearch(ServiceInformation serviceInformation) {
        Mockito.when(serviceInformationRepository.search(new ServiceId(serviceInformation.id())))
            .thenReturn(Optional.of(serviceInformation));
    }

    protected void shouldDelete(ServiceInformation serviceInformation) {
        verify(serviceInformationRepository, atLeastOnce()).delete(serviceInformation);
    }

    protected void shouldNotDelete(ServiceInformation serviceInformation) {
        verify(serviceInformationRepository, never()).delete(serviceInformation);
    }
}
