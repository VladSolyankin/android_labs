package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NestedListActivity extends AppCompatActivity {

    ArrayList<NestedList> nestedList;
    ArrayList<NestedListGroup> nestedListGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_list);

        RecyclerView rvNestedList = (RecyclerView) findViewById(R.id.rvNestedList);

        nestedList = NestedList.createNestedList(3);
        nestedListGroup = NestedListGroup.createNestedList(3);

        NestedListAdapter adapter = new NestedListAdapter(nestedList);
        NestedListGroupAdapter groupAdapter = new NestedListGroupAdapter(nestedListGroup);
        rvNestedList.setAdapter(adapter);
        rvNestedList.setLayoutManager(new LinearLayoutManager(this));
    }
}