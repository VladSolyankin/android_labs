package com.example.mobile_lab1;

public class  CookbookItem {
    private int itemResource;
    private String itemName;

    public CookbookItem(int itemResource, String itemName) {
        this.itemResource = itemResource;
        this.itemName = itemName;
    }

    public int getItemResource() {
        return itemResource;
    }

    public void setItemResource(int itemResource) {
        this.itemResource = itemResource;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
