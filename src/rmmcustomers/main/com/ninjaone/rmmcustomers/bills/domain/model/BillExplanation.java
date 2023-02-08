package com.ninjaone.rmmcustomers.bills.domain.model;

import com.ninjaone.rmmcustomers.bills.domain.BillExplanationCreatedDomainEvent;
import com.ninjaone.rmmcustomers.bills.domain.BillRecreatedDomainEvent;
import com.ninjaone.shared.domain.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.List;
import java.util.UUID;

@Entity
public class BillExplanation extends AggregateRoot {

    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;

    private List<BillItem> items;

    private BillExplanation(UUID id, List<BillItem> items) {
        this.id = id;
        this.items = items;

        record(new BillExplanationCreatedDomainEvent(id.toString()));
    }

    protected BillExplanation(){

    }

    public static BillExplanation create(String customerId, List<BillItem> items) {
        return new BillExplanation(UUID.fromString(customerId), items);
    }

    public void recreateFrom(List<BillItem> items) {
        items.clear();
        this.items = items;

        record(new BillRecreatedDomainEvent(id.toString()));
    }

    private double totalCost() {
        double cost = 0;
        for (BillItem item : items) {
            cost += item.cost();
        }

        return cost;
    }

    public String explain(){
        return this.toString();
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append(String.format("Total cost: %,.2f", totalCost()));
        builder.append("\n");

        for (BillItem item : items) {
            builder.append(String.format("Concept: %s  Cost: %,.2f", item.concept(), item.cost()));
        }

        return builder.toString();
    }
}
