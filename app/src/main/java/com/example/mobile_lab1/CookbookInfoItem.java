package com.example.mobile_lab1;

public class CookbookInfoItem {
    private int itemIcon;
    private String itemName;
    private int itemImage;
    private String itemReceipt;

    public CookbookInfoItem(int resource, String itemName, int itemImage, String itemReceipt) {
        this.itemIcon = resource;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemReceipt = itemReceipt;
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemReceipt() {
        return itemReceipt;
    }

    public void setItemReceipt(String itemReceipt) {
        this.itemReceipt = itemReceipt;
    }
}