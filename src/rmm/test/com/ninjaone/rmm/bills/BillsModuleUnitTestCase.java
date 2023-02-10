package com.ninjaone.rmm.bills;

import com.ninjaone.rmm.bills.domain.BillItemRepository;
import com.ninjaone.rmm.bills.domain.costcalculation.ServicePriceCalculator;
import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class BillsModuleUnitTestCase extends UnitTestCase {
    protected BillItemRepository billItemRepository;
    protected ServicePriceCalculator calculator;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        billItemRepository = mock(BillItemRepository.class);
        calculator = mock(ServicePriceCalculator.class);
        queryBus = mock(QueryBus.class);
    }

    public void shouldHaveSaved(BillItem item) {
        verify(billItemRepository, atLeastOnce()).save(item);
    }

    public void shouldCalculatePriceForService(Price price) {
        when(calculator.priceFor(any(), any(), any()))
            .thenReturn(price);
    }
}
