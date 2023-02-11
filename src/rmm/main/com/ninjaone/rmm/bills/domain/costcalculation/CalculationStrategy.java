package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.shared.domain.Price;

import java.util.List;
import java.util.Map;

public interface CalculationStrategy {
    Price calculate(Price price, List<Map.Entry<String, String>> policies, CalculationParams calculationParams);
}
