package com.ninjaone.rmm.orders.application.create;

import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.orders.OrdersModuleUnitTestCase;
import com.ninjaone.rmm.orders.create.CreateServiceOrderCommandHandler;
import com.ninjaone.rmm.orders.create.ServiceOrderCreator;
import com.ninjaone.rmm.orders.domain.ServiceOrderCreatedDomainEventMother;
import com.ninjaone.rmm.orders.domain.ServiceOrderMother;
import com.ninjaone.rmm.services.application.ServiceResponseMother;
import com.ninjaone.rmm.services.application.find.FindServiceByIdQuery;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.shared.domain.bus.query.QueryHandlerExecutionError;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateServiceOrderCommandHandlerShould extends OrdersModuleUnitTestCase {

    private CreateServiceOrderCommandHandler subject;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        ServiceOrderCreator creator = new ServiceOrderCreator(repository, eventBus, queryBus);
        subject = new CreateServiceOrderCommandHandler(creator);
    }

    @Test
    void should_create_a_service_order() {
        var service = ServiceInformationMother.antivirus("100");
        var response = ServiceResponseMother.fromService(service);

        DeviceInformation device = DeviceInformationMother.Windows();
        var command = CreateServiceOrderCommandMother.from(service, device);

        var order = ServiceOrderMother.from(command, service.name());

        shouldAsk(
            new FindServiceByIdQuery(command.serviceId()),
            response);

        subject.handle(command);

        shouldHaveSaved(order);

        shouldHavePublished(ServiceOrderCreatedDomainEventMother.fromOrder(order));
    }

    @Test
    void should_not_create_service_order_when_device_not_exist() {
        Assert.assertThrows(QueryHandlerExecutionError.class, ()-> {
            var command = CreateServiceOrderCommandMother.random();

            var order = ServiceOrderMother.fromCommand(command);

            shouldThrowWhenAskFor(
                new FindDeviceByIdQuery(command.deviceId()));

            subject.handle(command);

            shouldNotSave(order);
        });
    }

    @Test
    void should_not_create_service_order_when_servie_not_exist() {
        Assert.assertThrows(QueryHandlerExecutionError.class, ()-> {
            var command = CreateServiceOrderCommandMother.random();

            var order = ServiceOrderMother.fromCommand(command);

            shouldThrowWhenAskFor(
                new FindServiceByIdQuery(command.serviceId()));

            subject.handle(command);

            shouldNotSave(order);
        });
    }
}
