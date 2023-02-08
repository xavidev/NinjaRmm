package com.ninjaone.rmm.costs;

import com.ninjaone.rmm.costs.domain.DeviceCostRepository;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class CostsModuleUnitTestCase extends UnitTestCase {

    protected DeviceCostRepository repository;
    @BeforeEach
    protected void setUp(){
        repository = mock(DeviceCostRepository.class);
    }

//    public void shouldSearch(DeviceCost deviceCost) {
//        Mockito.when(repository.search(new DeviceCostId(deviceCost.id()))).thenReturn(Optional.of(deviceCost));
//    }

//    protected void shouldHaveSaved(DeviceCost deviceCost) {
//        verify(repository, atLeastOnce()).save(deviceCost);
//    }

//    protected void shouldDelete(DeviceCost deviceCost) {
//        verify(repository, atLeastOnce()).delete(device);
//    }
//
//    protected void shouldNotDelete(DeviceCost deviceCost) {
//        verify(repository, never()).delete(device);
//    }
}
