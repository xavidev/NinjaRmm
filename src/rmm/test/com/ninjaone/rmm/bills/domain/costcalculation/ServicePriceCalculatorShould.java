package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.rmm.bills.BillsModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.UuidMother;
import com.ninjaone.shared.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicePriceCalculatorShould extends BillsModuleUnitTestCase {

    private ServicePriceCalculator subject;
    @BeforeEach
    public void setUp() {

        subject = new ServicePriceCalculator();
    }

    @Test
    void should_calculate_price_for_service_without_cost_policies() {

        Price calculatedPrice = subject.priceFor(UuidMother.random(), UuidMother.random(), UuidMother.random());

        ServiceInformation service = ServiceInformationMother.antivirus("100");

        assertEquals(service.cost(), calculatedPrice);
    }
}
