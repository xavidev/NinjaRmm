package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.rmm.shared.domain.PerSameServiceCostPolicy;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;

@Service
public final class ForSameServicesCalculationStrategy extends ApplicableCalculationStrategy<PerSameServiceCostPolicy>{

    public ForSameServicesCalculationStrategy() {
        super(PerSameServiceCostPolicy.class);
    }

    @Override
    public boolean applyFor(String policyKey) {
        return false;
    }

    @Override
    protected Price doCalculation(Price price, PerSameServiceCostPolicy policy, CalculationParams calculationParams) {
        //Could be an implementation like:
            //Use the query bus to fetch in the orders module orders by customer per device
            //Make a calculation to apply a discount

        return price;
    }
}
