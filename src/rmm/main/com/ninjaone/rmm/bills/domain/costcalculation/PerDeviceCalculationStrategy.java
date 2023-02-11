package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.rmm.shared.domain.CostPolicy;
import com.ninjaone.rmm.shared.domain.PerDeviceTypeCostPolicy;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;

@Service
public class PerDeviceCalculationStrategy extends ApplicableCalculationStrategy<PerDeviceTypeCostPolicy> {
    public PerDeviceCalculationStrategy() {
        super(PerDeviceTypeCostPolicy.class);
    }

    @Override
    public boolean applyFor(String policyKey) {
        return policyKey.equals(CostPolicy.PER_DEVICE_TYPE.name());
    }

    @Override
    protected Price doCalculation(Price price, PerDeviceTypeCostPolicy policy, CalculationParams calculationParams) {
        if (policy.device().equals(calculationParams.deviceType())) {
            return new Price(policy.cost());
        }

        return price;
    }
}
