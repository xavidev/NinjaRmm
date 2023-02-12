package com.ninjaone.rmmcustomers.customerdevcies.application.explanation;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerService;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryHandler;
import com.ninjaone.shared.domain.criteria.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.groupingBy;

@Service
public final class CustomerDeviceExplanationQueryHandler implements QueryHandler<CustomerDeviceExplanationQuery, ExplanationResponse> {

    private final CustomerDeviceRepository repository;

    public CustomerDeviceExplanationQueryHandler(CustomerDeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExplanationResponse handle(CustomerDeviceExplanationQuery query) {

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.create("customerId", FilterOperator.EQUAL.value(), query.customerId()));

        var criteria = new Criteria(new Filters(filters), Order.none());

        List<CustomerDevice> customerDevices = repository.match(criteria);

        Price totalCost = new Price("0");
        for (CustomerDevice device : customerDevices) {
            totalCost = totalCost.plus(device.totalCost());
        }

        Price devicesCost = new Price("0");
        for (CustomerDevice device : customerDevices) {
            devicesCost = devicesCost.plus(device.deviceCost());
        }

        List<CustomerService> allServices = new ArrayList<>();
        for (CustomerDevice device : customerDevices) {
            allServices.addAll(device.services());
        }

        var groupedServices = allServices.stream().collect(groupingBy(CustomerService::name));

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Total Cost: %s\n", currencyFormat(totalCost.value())));
        builder.append("Explanation:\n");
        builder.append(String.format("\tDevices cost: %s\n", currencyFormat(devicesCost.value())));
        for (var group : groupedServices.entrySet()) {
            builder.append(String.format("\t%s cost: %s\n", group.getKey(), currencyFormat(group
                .getValue()
                .stream()
                .map(service -> service.cost().value())
                .reduce(new BigDecimal("0"), BigDecimal::add))));
        }

        return new ExplanationResponse(builder.toString());
    }

    private static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(n);
    }
}
