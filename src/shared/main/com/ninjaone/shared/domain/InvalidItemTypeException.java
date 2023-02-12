package com.ninjaone.shared.domain;

public final class InvalidItemTypeException extends DomainException {

    public InvalidItemTypeException(String itemType) {
        super("invalid_item_type", String.format("Te item type <%s> is invalid", itemType));
    }
}
