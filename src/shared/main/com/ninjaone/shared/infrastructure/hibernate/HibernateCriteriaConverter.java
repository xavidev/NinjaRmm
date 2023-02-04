package com.ninjaone.shared.infrastructure.hibernate;

import com.ninjaone.shared.domain.StringValue;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.domain.criteria.Filter;
import com.ninjaone.shared.domain.criteria.FilterOperator;
import jakarta.persistence.criteria.*;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;


public final class HibernateCriteriaConverter<T> {
    private final CriteriaBuilder builder;
    private final HashMap<FilterOperator, BiFunction<Filter, Root<T>, Predicate>> predicateTransformers = new HashMap<>() {{
        put(FilterOperator.EQUAL, HibernateCriteriaConverter.this::equalsPredicateTransformer);
    }};

    public HibernateCriteriaConverter(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public CriteriaQuery<T> convert(Criteria criteria, Class<T> aggregateClass) {
        CriteriaQuery<T> hibernateCriteria = builder.createQuery(aggregateClass);
        Root<T> root = hibernateCriteria.from(aggregateClass);

        hibernateCriteria.where(formatPredicates(criteria.filters().filters(), root));

        if (criteria.order().hasOrder()) {
            Path<Object> orderBy = root.get(criteria.order().orderBy().value());
            Order order = criteria.order().orderType().isAsc() ? builder.asc(orderBy) : builder.desc(orderBy);

            hibernateCriteria.orderBy(order);
        }

        return hibernateCriteria;
    }

    private Predicate[] formatPredicates(List<Filter> filters, Root<T> root) {
        List<Predicate> predicates = filters.stream()
            .map(filter -> formatPredicate(filter, root))
            .toList();

        Predicate[] predicatesArray = new Predicate[predicates.size()];

        return predicates.toArray(predicatesArray);
    }

    private Predicate formatPredicate(Filter filter, Root<T> root) {
        BiFunction<Filter, Root<T>, Predicate> transformer = predicateTransformers.get(filter.operator());

        return transformer.apply(filter, root);
    }

    private Predicate equalsPredicateTransformer(Filter filter, Root<T> root) {
        if (isValueObject(filter, root)) {
            return builder.equal(root.get(filter.field().value()).get("value"), filter.value().value());
        }
        return builder.equal(root.get(filter.field().value()), filter.value().value());
    }

    private boolean isValueObject(Filter filter, Root<T> root) {
        Class<?> javaType = root.get(filter.field().value()).getJavaType().getSuperclass();

        return javaType.isNestmateOf(StringValue.class);
    }
}
