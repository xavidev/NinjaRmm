package com.ninjaone.rmm.bills.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public class BillExplanation {
    private UUID customerId;
    private List<BillItem> items;

    private BillExplanation(UUID customerId, List<BillItem> items) {
        this.customerId = customerId;
        this.items = items;
    }

    protected BillExplanation(){

    }

    public static BillExplanation create(String customerId, List<BillItem> items) {
        if(items.isEmpty()) {
            throw new NoItemsToBillException(customerId);
        }

        return new BillExplanation(UUID.fromString(customerId), items);
    }
    public String explain(){
        var builder = new StringBuilder();
        builder.append(String.format("Total cost: %s", totalCost()));
        builder.append("\n");

        for (BillItem item : items) {
            builder.append(String.format("Concept: %s  Cost: %,.2f", item.concept(), item.cost()));
        }

        return builder.toString();
    }

    private String totalCost() {
        BigDecimal cost = BigDecimal.valueOf(0);

        for (BillItem item : items) {
            cost = cost.add(item.cost());
        }

        return cost.toString();
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
