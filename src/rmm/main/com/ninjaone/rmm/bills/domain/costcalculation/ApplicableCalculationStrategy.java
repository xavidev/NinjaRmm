package com.ninjaone.rmm.bills.domain.costcalculation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.rmm.shared.domain.ServiceCostPolicy;
import com.ninjaone.shared.domain.Price;

import java.util.List;
import java.util.Map;

public abstract class ApplicableCalculationStrategy<T extends ServiceCostPolicy> implements CalculationStrategy{

    ObjectMapper mapper;
    private Class<T> clazz;

    public ApplicableCalculationStrategy(Class<T> clazz) {
        this.clazz = clazz;
        mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public abstract boolean applyFor(String policyKey);

    @Override
    public Price calculate(Price price, List<Map.Entry<String, String>> policies, CalculationParams calculationParams) {

        for (Map.Entry<String, String> set : policies) {
            if(applyFor(set.getKey())){
                try {
                    price = doCalculation(price, mapper.readValue(set.getValue(), clazz), calculationParams);
                } catch (JsonProcessingException ex) {

                }
            }
        }

        return price;
    }

    protected abstract Price doCalculation(Price price, T policy, CalculationParams calculationParams);
}
