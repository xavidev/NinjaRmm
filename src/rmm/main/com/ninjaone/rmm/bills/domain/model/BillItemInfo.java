package com.ninjaone.rmm.bills.domain.model;

import java.util.Objects;

public class BillItemInfo {
    private final String concept;
    private final String itemType;
    private final String customerId;

    public BillItemInfo(String concept, String itemType, String customerId) {
        this.concept = concept;
        this.itemType = itemType;
        this.customerId = customerId;
    }

    private BillItemInfo() {

        customerId = null;
        itemType = null;
        concept = null;
    }

    public String concept() {
        return concept;
    }

    public String itemType() {
        return itemType;
    }

    public String customerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BillItemInfo) obj;
        return Objects.equals(this.concept, that.concept) &&
            Objects.equals(this.itemType, that.itemType) &&
            Objects.equals(this.customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concept, itemType, customerId);
    }

    @Override
    public String toString() {
        return "BillItemInfo[" +
            "concept=" + concept + ", " +
            "itemType=" + itemType + ", " +
            "customerId=" + customerId + ']';
    }

}
