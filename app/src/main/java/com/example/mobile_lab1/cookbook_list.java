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
                CookbookItem selectedItem = (CookbookItem) adapterView.getItemAtPosition(pos);
                Intent intent = new Intent(getApplicationContext(), cookbook_list_info.class);
                intent.putExtra("elementNumber", pos);
                intent.putExtra("itemName", selectedItem.getItemName());
                intent.putExtra("itemIcon", selectedItem.getItemResource());
                intent.putExtra("itemDescription", selectedItem.getItemDescription());
                intent.putExtra("itemInfoImage", selectedItem.getItemInfoImage());
                Log.d("Element position: ", String.valueOf(pos));
                startActivity(intent);
            }
        });
    }

    private void setInitialData() {
        cookbookItems.add(new CookbookItem(R.drawable.ic_borsch, "Борщ",
                R.drawable.borsch, "borsch.txt"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_cesar, "Цезарь",
                R.drawable.cesar, "cesar.txt"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_milkshake, "Мол. коктель",
                R.drawable.milkshake, "milkshake.txt"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_blinchik, "Блинчики",
                R.drawable.blinchik, "blinchik.txt"));
        cookbookItems.add(new CookbookItem(R.drawable.ic_spagetti, "Спагетти",
                R.drawable.spagetti, "spagetti.txt"));
    }
}