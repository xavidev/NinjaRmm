package com.ninjaone.shared.domain;

public final class ItemType {

    private String itemType;

    public ItemType(String itemType) {
        assert itemType != null;

        if(!itemType.equals("device") && !itemType.equals("service")){
            throw new InvalidItemTypeException(itemType);
        }

        this.itemType = itemType;
    }

    public boolean isDevice(){
        return itemType.equals("device");
    }

    public boolean isService(){
        return itemType.equals("service");
    }
}
