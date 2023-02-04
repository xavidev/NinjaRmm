package com.ninjaone.rmm.costs;

import com.ninjaone.rmm.costs.domain.CostPolicyRepository;
import com.ninjaone.rmm.costs.domain.model.CostPolicy;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class CostsModuleUnitTestCase {

    protected ServiceRepository serviceRepository;
    protected CostPolicyRepository costPolicyRepository;

    @BeforeEach
    protected void setUp(){
        serviceRepository = mock(ServiceRepository.class);
        costPolicyRepository = mock(CostPolicyRepository.class);
    }

    protected void shouldHaveSaved(CostPolicy costPolicy) {
        verify(costPolicyRepository, atLeastOnce()).save(costPolicy);
    }

    protected void shouldSearch(Service service) {
        when(serviceRepository.search(new ServiceId(service.id()))).thenReturn(Optional.of(service));
    }
}
