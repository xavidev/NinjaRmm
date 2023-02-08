package com.ninjaone.rmm.services.application.calculatecost;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;
import com.ninjaone.shared.domain.devices.CustomerDeviceCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({CustomerDeviceCreatedDomainEvent.class})
public final class CalculateCostOnCustomerDeviceCreated {

    private final ServiceCostCalculator calculator;

    public CalculateCostOnCustomerDeviceCreated(ServiceCostCalculator calculator) {
        this.calculator = calculator;
    }

    @EventListener
    public void on(CustomerDeviceCreatedDomainEvent event){
        event.services()
            .forEach(service -> calculator.calculate(event.devicetype(), service));
    }
}
