package com.ninjaone.rmm.bills;

import com.ninjaone.rmm.bills.domain.BillItemRepository;
import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class BillsModuleUnitTestCase extends UnitTestCase {
    protected BillItemRepository billItemRepository;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        billItemRepository = mock(BillItemRepository.class);
    }

    public void shouldHaveSaved(BillItem item) {
        verify(billItemRepository, atLeastOnce()).save(item);
    }
}
