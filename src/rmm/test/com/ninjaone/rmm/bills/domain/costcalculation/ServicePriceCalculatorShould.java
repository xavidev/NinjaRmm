package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.rmm.bills.BillsModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.services.application.ServiceResponseMother;
import com.ninjaone.rmm.services.application.find.FindServiceByIdQuery;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.UuidMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicePriceCalculatorShould extends BillsModuleUnitTestCase {
    @BeforeEach
    public void setUp() {
        super.setUp();

        var strategies = new ArrayList<CalculationStrategy>();
        strategies.add(new PerDeviceCalculationStrategy());
        strategies.add(new ForSameServicesCalculationStrategy());

        calculator = new ServicePriceCalculator(queryBus, strategies);
    }

    @Test
    void should_calculate_price_for_service_without_cost_policies() {
        ServiceInformation service = ServiceInformationMother.antivirus("100");
        DeviceInformationMother.Windows();

        shouldAsk(new FindServiceByIdQuery(service.id()), ServiceResponseMother.fromService(service));

        Price calculatedPrice = calculator.priceFor(UuidMother.random(), service.id(), UuidMother.random(), DeviceInformationMother.Windows().type());

        assertEquals(service.cost(), calculatedPrice);
    }

    @Test
    void should_calculate_price_for_service_with_device_type_cost_policy() {
        var serviceDevice = DeviceInformationMother.Mac();

        ServiceInformation service = ServiceInformationMother.antivirus("100");
        service.addCostPolicy(ServiceCostPolicyMother.forDevice(DeviceInformationMother.Mac(), "150"));
        service.addCostPolicy(ServiceCostPolicyMother.forDevice(DeviceInformationMother.Windows(), "100"));

        shouldAsk(new FindServiceByIdQuery(service.id()), ServiceResponseMother.fromService(service));

        Price calculatedPrice = calculator.priceFor(UuidMother.random(), service.id(), serviceDevice.id(), serviceDevice.type());

        assertEquals(new Price("150"), calculatedPrice);
    }
}
