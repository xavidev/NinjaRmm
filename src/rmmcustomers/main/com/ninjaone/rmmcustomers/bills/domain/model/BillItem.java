package com.ninjaone.rmmcustomers.bills.domain.model;

import com.ninjaone.rmmcustomers.bills.domain.BillItemCreatedDomainEvent;
import com.ninjaone.shared.domain.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.UUID;

@Entity
public class BillItem extends AggregateRoot {
    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;
    private String customerId;
    private String concept;

    private String itemType;
    private double cost;

    protected BillItem(){

    }

    public BillItem(UUID id, String customerId, String concept, String itemType, double cost) {

        this.id = id;
        this.customerId = customerId;
        this.concept = concept;
        this.cost = cost;

        record(new BillItemCreatedDomainEvent(id.toString(), customerId, concept, cost));
    }

    public static BillItem create(String itemRef, String customerId, String concept, String itemType, double cost) {
        return new BillItem(UUID.fromString(itemRef), customerId, concept, itemType, cost);
    }
}
