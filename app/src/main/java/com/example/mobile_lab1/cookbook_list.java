package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                R.layout.activity_cookbook_item, cookbookItems);

        itemsListView.setAdapter(adapter);

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent intent = new Intent(getApplicationContext(), cookbook_list_info.class);
                intent.putExtra("elementNumber", pos);
                Log.d("Element position: ", String.valueOf(pos));
                startActivity(intent);
            }
        });
    }

    private void setInitialData() {
        cookbookItems.add(new CookbookItem(R.drawable.ic_borsch, "Борщ"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_cesar, "Цезарь"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_milkshake, "Мол. коктель"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_blinchik, "Блинчики"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_spagetti, "Спагетти"));
    }
}