package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.shared.domain.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class FindCriteria {

    public static Criteria perDeviceType(String type){
        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.create("type", FilterOperator.EQUAL.value(), type));

        return new Criteria(new Filters(filters), Order.none());
    }
}
