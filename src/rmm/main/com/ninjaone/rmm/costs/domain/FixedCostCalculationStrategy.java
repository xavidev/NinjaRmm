package com.ninjaone.rmm.costs.domain;

public final class FixedCostCalculationStrategy implements IPriceCalculationStrategy {
    @Override
    public double calculate(double count, double cost) {
        return count * cost;
    }
}
