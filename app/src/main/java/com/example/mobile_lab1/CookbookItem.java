package com.example.mobile_lab1;

public class CookbookItem {
    private int itemResource;
    private String itemName;
    private int itemInfoImage;
    private String itemDescription;

    public CookbookItem(int itemResource, String itemName, int itemInfoImage, String itemDescription) {
        this.itemResource = itemResource;
        this.itemName = itemName;
        this.itemInfoImage = itemInfoImage;
        this.itemDescription = itemDescription;
    }

    public int getItemInfoImage() {
        return itemInfoImage;
    }

    public void setItemInfoImage(int itemInfoImage) {
        this.itemInfoImage = itemInfoImage;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
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
