package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewExample extends AppCompatActivity {
    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        TextView selection = (TextView) findViewById(R.id.selection);
        ListView countriesList = (ListView) findViewById(R.id.countriesList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, countries);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                String selectedItem = countries[pos];
                selection.setText(selectedItem);
            }
        });
    }
}