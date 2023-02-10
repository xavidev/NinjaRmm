package com.ninjaone.rmm.bills.domain.costcalculation;

import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;

@Service
public class ServicePriceCalculator {
    public Price priceFor(String customerId, String serviceId, String deviceId ) {
        return new Price("0");
    }
}
