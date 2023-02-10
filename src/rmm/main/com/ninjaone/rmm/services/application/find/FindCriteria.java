package com.ninjaone.rmm.services.application.find;

import com.ninjaone.shared.domain.criteria.*;

import java.util.ArrayList;
import java.util.List;

public final class FindCriteria {

    public static Criteria byName(String name) {
        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.create("name", FilterOperator.EQUAL.value(), name));

        return new Criteria(new Filters(filters), Order.none());
    }
}
