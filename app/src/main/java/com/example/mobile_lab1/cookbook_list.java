package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class cookbook_list extends AppCompatActivity {

    ArrayList<CookbookItem> cookbookItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook_list);

        setInitialData();
        ListView itemsListView = findViewById(R.id.cookbookItemsList);
        CookbookAdapter adapter = new CookbookAdapter(this,
                R.layout.activity_cookbook_list, cookbookItems);

        itemsListView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                CookbookItem selectedState = (CookbookItem) adapterView.getItemAtPosition(pos);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " +
                        selectedState.getItemName(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void setInitialData() {
        cookbookItems.add(new CookbookItem(R.drawable.borsch, "Борщ"));
        cookbookItems.add(new CookbookItem(R.drawable.cesar, "Цезарь"));
        cookbookItems.add(new CookbookItem(R.drawable.milkshake, "Мол. коктель"));
        cookbookItems.add(new CookbookItem(R.drawable.blinchik, "Блинчики"));
        cookbookItems.add(new CookbookItem(R.drawable.spagetti, "Спагетти"));
    }
}