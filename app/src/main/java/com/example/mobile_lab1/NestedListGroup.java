package com.example.mobile_lab1;

import java.util.ArrayList;

public class NestedListGroup {

    private int itemResource;
    private String itemName;
    public NestedListGroup(int itemResource, String itemName) {
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
    public static ArrayList<NestedListGroup> createNestedList(int listCount) {
        ArrayList<NestedListGroup> nestedList = new ArrayList<>();
        ArrayList<Integer> images = new ArrayList<>();

        images.add(R.drawable.milkshake);
        images.add(R.drawable.cesar);
        images.add(R.drawable.borsch);

        for (int i = 0; i < listCount; i++) {
            nestedList.add(new NestedListGroup(images.get(i % 3),"Item " + (i+1)));
        }
        return nestedList;
    }


}
