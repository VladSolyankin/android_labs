package com.example.mobile_lab1;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NestedList {
    private String groupName;

    private NestedListGroup groupElements;

    public NestedList(String groupName, NestedListGroup groupElements) {
        this.groupName = groupName;
        this.groupElements = groupElements;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public NestedListGroup getGroupElements() {
        return groupElements;
    }

    public void setGroupElements(NestedListGroup groupElements) {
        this.groupElements = groupElements;
    }

    public static ArrayList<NestedList> createNestedList(int listCount) {
        ArrayList<NestedList> nestedList = new ArrayList<>();
        for (int i = 0; i < listCount; i++) {
            nestedList.add(new NestedList("Group " + i,
                    new NestedListGroup(0, "")));
        }
        return nestedList;
    }
}
