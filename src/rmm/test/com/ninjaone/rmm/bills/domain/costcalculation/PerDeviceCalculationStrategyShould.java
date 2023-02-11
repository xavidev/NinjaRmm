package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.PerDeviceTypeCostPolicy;
import com.ninjaone.shared.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerDeviceCalculationStrategyShould {

    private PerDeviceCalculationStrategy subject;

    @BeforeEach
    public void setUp(){
        subject = new PerDeviceCalculationStrategy();
    }

    @Test
    void should_calcualte_service_price_per_device(){
        ServiceInformation service = ServiceInformationMother.antivirus("50");
        service.addCostPolicy(new PerDeviceTypeCostPolicy("Windows", "100"));
        service.addCostPolicy(new PerDeviceTypeCostPolicy("Mac", "300"));

        Price price = subject.calculate(service.cost(), service.costPolicies(), CalculationParamsMother.forDevice("Windows"));

        assertEquals(new Price("100"), price);
    }
}
